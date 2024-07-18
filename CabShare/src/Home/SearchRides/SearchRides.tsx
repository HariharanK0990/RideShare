import { useEffect, useState } from "react";
import { Rides } from "../MyRides/Rides";
import styles from "./SearchRides.module.css";
import { axiosApi, router } from "../../main";

export const SearchRides = () => {
  const [rides, setRides] = useState([]);

  const [confirm, setConfirm] = useState(false);
  const [current, setCurrent] = useState(0);

  const confirmDialogEvent = (id: any) => {
    setCurrent(id);
    setConfirm(true);
  };

  const [data, setData] = useState({ source: "", destination: "", date: "" });

  const handleData = (e: any) => {
    const { name, value } = e.target;

    setData({
      ...data,
      [name]: value,
    });
  };

  const ConfirmDialog = () => {
    return (
      <div className={styles.dialog}>
        <p className={styles.dialogP}>Join this Ride?</p>
        <div className={styles.dialogDiv}>
          <button
            className={styles.dialogButton}
            onClick={() => setConfirm(false)}
          >
            Cancel
          </button>
          <button className={styles.dialogButton} onClick={() => func(current)}>
            Accept
          </button>
        </div>
      </div>
    );
  };

  const func = async (rideId: any) => {
    console.log(sessionStorage.getItem("user"));
    try {
      const response = await axiosApi.post("/api/ride/join", {
        userId: `${sessionStorage.getItem("user")}`,
        rideId: `${rideId}`,
      });
      alert("Joined");
      router.navigate("/home");
    } catch (e: any) {
      console.log(e.message);
      alert("already in ride");
      setConfirm(false);
    }
  };

  useEffect(() => {
    const getRides = async () => {
      try {
        const response = await axiosApi.post(
          "/api/ride/getRidesBySearch",
          data
        );
        setRides(response.data);
        console.log(response.data);
      } catch (e) {
        alert("No rides");
      }
    };
    getRides();
  }, [data]);

  return (
    <div className={styles.mainContainer}>
      <div className={styles.searchBar}>
        <p className={styles.searchp}>From</p>
        <input
          type="text"
          name="source"
          className={styles.searchInput}
          onChange={handleData}
        />
        <input
          type="date"
          name="date"
          className={styles.searchDate}
          onChange={handleData}
        />
      </div>
      <div className={styles.searchBar}>
        <p className={styles.searchp}>To</p>
        <input
          type="text"
          name="destination"
          className={styles.searchInput}
          onChange={handleData}
        />
      </div>
      <div className={styles.searchRides}>
        {rides.map((item) => (
          <Rides rideId={item} func={confirmDialogEvent} />
        ))}
      </div>
      {confirm ? <ConfirmDialog /> : ""}
    </div>
  );
};
