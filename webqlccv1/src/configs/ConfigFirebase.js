import firebase from 'firebase/app';

import 'firebase/analytics';
import 'firebase/auth';
import 'firebase/firestore';
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyBr7aVyKyaT89GMTTGxtZOlzVFfiTvAOIo",
  authDomain: "chat-app-apartment.firebaseapp.com",
  projectId: "chat-app-apartment",
  storageBucket: "chat-app-apartment.appspot.com",
  messagingSenderId: "110431670469",
  appId: "1:110431670469:web:d34946b2554cd95b5e20ac",
  measurementId: "G-2VT7W9CQNC"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);