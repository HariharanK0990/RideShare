import { NavLink } from "react-router-dom";
import styles from "./Root.module.css";

import car from "../Assets/car.png";
import search from "../Assets/search.png";
import history from "../Assets/history.png";
import { AnimatePresence, motion } from "framer-motion";

export const SideBar = ({
  isOpen,
  setIsOpen,
}: {
  isOpen: boolean;
  setIsOpen: React.Dispatch<React.SetStateAction<boolean>>;
}) => {
  return (
    <AnimatePresence>
      {isOpen && (
        <motion.div
          className={styles.sideBarFilter}
          animate={{ opacity: 1 }}
          initial={{ opacity: 0 }}
          exit={{ opacity: 0 }}
          transition={{ ease: "linear", duration: "0.2" }}
        >
          <motion.div
            className={styles.sideBar}
            animate={{ translateX: "0%" }}
            initial={{ translateX: "-100%" }}
            exit={{ translateX: "-100%" }}
            transition={{ ease: "linear", duration: "0.3" }}
          >
            <NavLink
              to="/home"
              className={styles.sideBarOptions}
              onClick={() => setIsOpen(false)}
            >
              <img src={car} className={styles.optionImg} />
              <p className={styles.option}>My Rides</p>
            </NavLink>
            <NavLink
              to="/search"
              className={styles.sideBarOptions}
              onClick={() => setIsOpen(false)}
            >
              <img src={search} className={styles.optionImg} />
              <p className={styles.option}>Search Cabs</p>
            </NavLink>
          </motion.div>
        </motion.div>
      )}
    </AnimatePresence>
  );
};
