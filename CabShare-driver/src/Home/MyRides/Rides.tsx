import styles from "./MyRides.module.css";

import calendar from "../../Assets/calendar.png";
import arrivals from "../../Assets/arrivals.png";
import departures from "../../Assets/departures.png";
import group from "../../Assets/group.png";
import rupee from "../../Assets/rupee.png";

import avatar from "../../Assets/avatar.jpeg";
import { useEffect, useState } from "react";
import { axiosApi } from "../../main";

export const Rides = ({ rideId, func }: { rideId: number; func: any }) => {
  const [data, setData] = useState();
  const [driver, setDriver] = useState();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data: response } = await axiosApi.get(
          `/api/ride/getRideDetails/${rideId}`
        );
        console.log(response);
        setData(response);
      } catch (e) {
        console.log(e);
      }
    };
    fetchData();
  }, []);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const { data: response } = await axiosApi.get(
          `/api/driver/ride/driverdetails/${data?.driverId}`
        );
        console.log(response);
        setDriver(response);
      } catch (e) {
        console.log(e);
      }
    };
    fetchData();
  }, [data]);

  return (
    <div className={styles.rides} onClick={async () => await func(rideId)}>
      <div className={styles.users}>
        <div className={styles.data}>
          <img src={calendar} className={styles.data} />
          <p className={styles.data}>{`${data?.date} at ${data?.time}`}</p>
        </div>
        <div className={styles.data}>
          <img src={departures} className={styles.data} />
          <p className={styles.data}>{data?.source}</p>
        </div>
        <div className={styles.data}>
          <img src={arrivals} className={styles.data} />
          <p className={styles.data}>{data?.destination}</p>
        </div>
        <div className={styles.data}>
          <img src={group} className={styles.data} />
          <p className={styles.data}>{`${data?.capacity}/4`}</p>
        </div>
        <div className={styles.data}>
          <img src={rupee} className={styles.data} />
          <p className={styles.data}>{data?.price}</p>
        </div>
      </div>
      <div className={styles.driver}>
        <img className={styles.driverPfp} src={driver ? driver?.dp : avatar} />
        <p className={styles.driverName}>
          {driver ? driver.name : "No driver"}
        </p>
        <p className={styles.driverName}>{driver ? driver.licensePlate : ""}</p>
        <p className={styles.driverName}>{driver ? driver.phoneNo : ""}</p>
      </div>
    </div>
  );
};
