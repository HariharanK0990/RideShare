import styles from "./MyRides.module.css";
import { Rides } from "./Rides";
import send from "../../Assets/paper-plane.png";
import close from "../../Assets/close.png";
import { useEffect, useState } from "react";
import { axiosApi } from "../../main";

export const MyRides = () => {
  const [data, setData] = useState([]);
  const [current, setCurrent] = useState(0);
  const [chat, setChat] = useState(false);

  const func = (rideId: any) => {
    setCurrent(rideId);
    setChat(true);
  };

  useEffect(() => {
    const id = sessionStorage.getItem("driver");
    console.log(id);
    const fetchData = async () => {
      try {
        const { data: response } = await axiosApi.get(
          `/api/driver/ride/myrides/${id}`
        );
        setData(response);
        console.log(response);
      } catch (e) {
        console.log(e);
      }
    };
    fetchData();
  }, []);

  return (
    <div className={styles.mainContainer}>
      <p className={styles.header}>My Rides</p>
      {data.map((item: any) => (
        <Rides rideId={item} func={func} />
      ))}
      {chat ? <Chat rideId={current} setChat={setChat} /> : ""}
    </div>
  );
};

const Chat = ({ rideId, setChat }) => {
  const [messages, setMessages] = useState([]);
  const [myMessage, setMyMessage] = useState("");
  const [render, setRender] = useState(false);
  useEffect(() => {
    const poll = setInterval(() => {
      setRender(!render);
    }, 5000);
    const fetchData = async () => {
      try {
        const { data: response } = await axiosApi.get(
          `/api/message/rideMessages/${rideId}`
        );
        setMessages(response);
        console.log(messages);
      } catch (e) {
        console.log(e);
      }
    };
    fetchData();

    return () => clearInterval(poll);
  }, [render]);

  useEffect(() => {
    console.log(messages);
  }, [messages]);

  const sendMessage = async () => {
    const id = sessionStorage.getItem("driver");
    try {
      const response = await axiosApi.post("/api/message/driver", {
        message: myMessage,
        rideId: rideId,
        userId: id,
      });
      setMyMessage("");
      setRender(!render);
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <div className={styles.chat}>
      <img
        src={close}
        style={{
          height: "4%",
          marginRight: "5px",
          marginTop: "5px",
          float: "right",
          zIndex: "3",
        }}
        onClick={() => setChat(false)}
      />
      <div className={styles.chatMessages}>
        {messages.map((item) => (
          <ChatBlob msg={item} />
        ))}
      </div>
      <div style={{ display: "flex", height: "7%", justifyContent: "center" }}>
        <input
          className={styles.chatInput}
          value={myMessage}
          onChange={(e) => setMyMessage(e.target.value)}
        />
        <img
          src={send}
          style={{
            height: "65%",
            width: "auto",
            marginTop: "auto",
            marginBottom: "auto",
            marginLeft: "2%",
          }}
          onClick={async () => await sendMessage()}
        />
      </div>
    </div>
  );
};

const ChatBlob = ({ msg }) => {
  return (
    <div className={styles.chatPDiv}>
      <p className={styles.chatP}>{msg}</p>
    </div>
  );
};
