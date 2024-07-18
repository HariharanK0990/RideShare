import { Link } from "react-router-dom";
import styles from "./Login.module.css";
import { axiosApi, router } from "../main";
import { useState } from "react";

export const Login = () => {
  const login = async () => {
    try {
      console.log(loginData);
      const response = await axiosApi.post("/api/signin/drivers", {
        phoneNo: loginData.phoneNo,
        password: loginData.password,
      });
      console.log(response);
      sessionStorage.setItem("driver", response.data);
      router.navigate("/home");
    } catch (e) {
      console.log(e);
      alert("Invalid username or password");
    }
  };

  const [loginData, setLoginData] = useState({
    phoneNo: "",
    password: "",
  });

  const handleState = (e: any) => {
    const { name, value } = e.target;

    setLoginData({
      ...loginData,
      [name]: value,
    });
  };

  return (
    <div className={styles.mainContainer}>
      <div>
        <h1 className={styles.h1}>RideShare</h1>
        <h2 className={styles.h2}>Driver Login</h2>
        <div className={styles.inputDiv}>
          <input
            type="text"
            placeholder="Phone No"
            name="phoneNo"
            className={styles.input}
            onChange={(e) => handleState(e)}
          />
          <input
            type="password"
            name="password"
            placeholder="password"
            className={styles.input}
            onChange={(e) => handleState(e)}
          />
          <button className={styles.loginButton} onClick={login}>
            Login
          </button>
          <Link className={styles.newButton} to={"/register"}>
            Dont have account? Create Driver account
          </Link>
        </div>
      </div>
    </div>
  );
};
