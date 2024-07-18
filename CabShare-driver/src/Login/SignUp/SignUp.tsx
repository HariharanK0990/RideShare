import { useEffect, useState } from "react";
import styles from "./SignUp.module.css";
import { axiosApi, router } from "../../main";

export const SignUp = () => {
  const [data, setData] = useState({
    name: "",
    phoneNo: "",
    password: "",
    email: "",
    licensePlate: "",
    dp: "",
  });

  const [pas, setPas] = useState("");

  const handleData = (e: any) => {
    const { name, value } = e.target;

    setData({
      ...data,
      [name]: value,
    });
  };

  const isValidFileUploaded = (file) => {
    const validExtensions = ["png", "jpeg", "jpg"];
    const fileExtension = file.type.split("/")[1];
    return validExtensions.includes(fileExtension);
  };

  const handleFileChange = async (e) => {
    const file = e.target.files[0];
    if (!isValidFileUploaded(file)) {
      alert("invalid file type");
      e.target.value = "";
      return;
    }
    const base64 = await toBase64(file);
    const name = e.target.name;
    setData({ ...data, [name]: base64 });
  };

  const signUp = async (e: any) => {
    e.preventDefault();
    if (data.password != pas) {
      alert("Passwords dont match");
      return;
    }
    if (
      data.name == "" ||
      data.email == "" ||
      data.phoneNo == "" ||
      data.password == "" ||
      data.licensePlate == "" ||
      data.dp == ""
    ) {
      alert("Cannot leave empty field");
      return;
    }
    try {
      const response = await axiosApi.post("/api/signup/drivers", data);
      alert("Created account");
      router.navigate("/");
    } catch (e: any) {
      alert("Error");
      console.log(e);
      if (e.response.status == 400) alert("Phone no already exists");
    }
  };
  useEffect(() => {
    console.log(data.password);
  });
  return (
    <div className={styles.mainContainer}>
      <h1 className={styles.h1}>Register</h1>
      <div className={styles.inputDiv}>
        <input
          type="text"
          name="name"
          className={styles.input}
          placeholder="Name"
          onChange={(e) => handleData(e)}
        />
        <input
          type="text"
          name="phoneNo"
          className={styles.input}
          placeholder="Phone No"
          onChange={(e) => handleData(e)}
        />
        <input
          type="text"
          name="licensePlate"
          className={styles.input}
          placeholder="License Plate"
          onChange={(e) => handleData(e)}
        />
        <input
          type="password"
          name="password"
          className={styles.input}
          placeholder="Password"
          onChange={(e) => handleData(e)}
        />
        <input
          type="password"
          name="password2"
          className={styles.input}
          placeholder="Re enter password"
          onChange={(e) => setPas(e.target.value)}
        />
        <input
          type="text"
          name="email"
          className={styles.input}
          placeholder="email"
          onChange={(e) => handleData(e)}
        />
        <label className={styles.inputFile}>Profile picture</label>
        <input
          type="file"
          name="dp"
          accept=".jpeg,.png"
          className={styles.inputFile}
          onChange={async (e) => {
            handleFileChange(e);
          }}
        />
        <button className={styles.create} onClick={signUp}>
          SignUp
        </button>
      </div>
    </div>
  );
};

const toBase64 = (file) =>
  new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => resolve(reader.result);
    reader.onerror = reject;
  });
