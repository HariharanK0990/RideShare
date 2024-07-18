import styles from "./Root.module.css";

import { SideBar } from "./SideBar";
import { useState } from "react";
import { Outlet } from "react-router-dom";

import menu from "../Assets/menu.png";
import avatar from "../Assets/avatar.jpeg";

export const Root = () => {
  const [isOpenSB, setIsOpenSB] = useState(false);

  const [userPfp, setUserPfp] = useState(avatar);

  return (
    <div className={styles.mainContainer}>
      <nav className={styles.navBar}>
        <button
          className={styles.sideDraw}
          onClick={() => setIsOpenSB(!isOpenSB)}
        >
          <img src={menu} className={styles.sideDraw} />
        </button>
        <p className={styles.heading}>RideShare</p>
        <div className={styles.userPFP}></div>
      </nav>
      <SideBar isOpen={isOpenSB} setIsOpen={setIsOpenSB} />
      <Outlet />
    </div>
  );
};
