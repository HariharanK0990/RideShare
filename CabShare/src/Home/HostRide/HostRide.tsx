import { useState } from "react";
import styles from "./HostRide.module.css";
import { axiosApi, router } from "../../main";

export const HostRide = () => {
  const createRide = async () => {
    try {
      console.log(data);
      const response = await axiosApi.post("/api/ride/create", data);
      console.log(response);
      alert("Created Ride");
      router.navigate("/home");
    } catch (e) {
      console.log(e);
      alert("Error when creating ride");
    }
  };

  const [data, setData] = useState({
    userId: sessionStorage.getItem("user"),
    price: "",
    source: "",
    destination: "",
    departure: "",
    date: "",
    time: "",
  });

  const handleState = (e: any) => {
    const { name, value } = e.target;

    setData({
      ...data,
      [name]: value,
    });
    console.log(data);
  };

  return (
    <div className={styles.mainContainer}>
      <h1 className={styles.header}>Post a Ride</h1>
      <input
        type="text"
        name="source"
        placeholder="Pickup Location"
        className={styles.inputText}
        onChange={(e) => handleState(e)}
      />
      <input
        type="text"
        name="destination"
        placeholder="Drop location"
        className={styles.inputText}
        onChange={(e) => handleState(e)}
      />
      <input
        type="text"
        placeholder="Bid Price"
        name="price"
        className={styles.inputText}
        onChange={(e) => handleState(e)}
      />
      <div style={{ display: "flex", height: "7%" }}>
        <input
          type="date"
          name="date"
          className={styles.inputDate}
          style={{ marginRight: "5px" }}
          onChange={(e) => handleState(e)}
        />
        <input
          type="time"
          name="time"
          placeholder="time"
          className={styles.inputDate}
          style={{ marginLeft: "5px" }}
          onChange={(e) => handleState(e)}
        />
      </div>
      <button className={styles.createButton} onClick={createRide}>
        Create Ride
      </button>
    </div>
  );
};
