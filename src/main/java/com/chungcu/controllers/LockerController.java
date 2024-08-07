/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungcu.controllers;

import com.chungcu.pojo.Apartment;
import com.chungcu.pojo.Locker;
import com.chungcu.pojo.Order1;
import com.chungcu.services.LockerService;
import com.chungcu.services.OrderService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author tien
 */
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:configs.properties")

public class LockerController {

    @Autowired
    private LockerService lockerService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private Environment env;

    @GetMapping("/locker")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String lockerView(Model model, @RequestParam Map<String, String> params) {
        int pagesize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        List<Locker> locker = lockerService.getAllLocker(params);
        int counter = lockerService.countLocker(params);
        String kw = params.get("kw");
        model.addAttribute("keyword", kw);
        model.addAttribute("counter", Math.ceil((counter) * 1.0 / pagesize));
        model.addAttribute("lockers", locker);
        return "locker";
    }

    @GetMapping("/addLocker")
    public String addLockerView(Model model) {
        model.addAttribute("locker", new Locker());
        return "addLocker";
    }

    @PostMapping("/addLocker")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addLocker(@ModelAttribute(value = "locker") @Valid Locker locker, BindingResult result) {
        if (!result.hasErrors()) {
            if (lockerService.addOrUpdateLocker(locker) == true) {
                return "redirect:/admin/locker";
            }
        }
        return "addLocker";
    }

    @GetMapping("/addLocker/{id}")
    public String updateView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("locker", this.lockerService.getLockerById(id));
        return "addLocker";
    }

    @GetMapping("deleteLocker/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteLocker(@PathVariable(value = "id") int lockerId, Model model) {
        model.addAttribute("locker", lockerService.getLockerById(lockerId));
        return "deleteLocker";
    }

    @PostMapping("deleteLocker")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String submitDeleteLocker(@ModelAttribute(value = "locker") Locker locker) {
        if (lockerService.deleteLocker(locker.getId()) == true) {
            return "redirect:/admin/locker";
        }
        return "adminHome";
    }

    @GetMapping("/order/{id}")
    public String OrderView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("locker", lockerService.getLockerById(id));
        return "order";
    }

    @GetMapping("/addOrder/{id}")
    public String addOrderView(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("lockerId", id);
        model.addAttribute("order", new Order1());
        return "addOrder";
    }

    @PostMapping("/addOrder")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addOrder(@ModelAttribute(value = "order") Order1 order) {
        int id = order.getLockerId().getId();
        if (orderService.addOrUpdateOrder(order) == true) {
            return "redirect:/admin/order/" + id;
        }
        return "addOrder";
    }
    
    @GetMapping("/confirmTakeOrder/{id}")
    public String confirmTakeOrder(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("order", orderService.getOrderById(id));
        return "confirmTakeOrder";
    }
    
    @PostMapping("/confirmTakeOrder/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateStatusOrder(@PathVariable(value = "id") int id) {
        Order1 updateOrder =  orderService.getOrderById(id);
        updateOrder.setStatus("Đã nhận hàng");
        if (orderService.addOrUpdateOrder(updateOrder) == true) {
            return "redirect:/admin/locker";
        }
        return "addOrder";
    }
}
