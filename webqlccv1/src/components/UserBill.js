import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import cookie from "react-cookies";
import { authApi, endpoints } from "../configs/Apis";

const UserBill = () => {

  const [bills, setBills] = useState(null);

  const handlePayment = async (bill) => {
    try {

      const resPayment = await authApi().post(endpoints['create-payment'], {
        ...bill
      })
      if(resPayment.status === 200){
        console.log(resPayment.data);
        window.open(resPayment.data.url);
      }
    }
    catch (err){
      console.err(err);
    };
  };

  useEffect(() => {
    const userInfo = cookie.load("user");
    console.log(userInfo)
    const loadBill = async () => {
      try {
        let res = await authApi().get(endpoints['user-bill'], {
          params: {
            id: userInfo.id
          }
        });
        console.log(res.data)
        const resBill = res.data;
        setBills(resBill);
        if(resBill.payment){
          console.log('show modal')
        }
      } catch (ex) {
        console.error(ex);
      }
    }

    loadBill();
  }, []);

  return (
    <>
      <h1>CÁC HÓA ĐƠN CỦA BẠN</h1>
      <Table striped="columns">
        <thead>
          <tr>
            <th>Loại hóa đơn</th>
            <th>Số tiền</th>
            <th>Ngày hết hạn</th>
            <th>Tình trạng</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
            {bills?.length > 0 && bills.map((bill, index) => (
              <tr>
                <td key={index}>{bill?.type}</td>
                <td key={index}>{bill?.amount}</td>
                <td key={index}>{bill?.dueDate}</td>
                <td key={index}>{bill?.paymentStatus}</td>
                <td><button onClick= {() => handlePayment(bill)}>Thanh toán</button></td>
                 </tr>
            ))}
        </tbody>
      </Table>
    </>
  )
}

export default UserBill;
