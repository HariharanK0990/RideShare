import React from "react";
import ReactDOM from "react-dom/client";
import { Root } from "./Home/Root";
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import "@fontsource/roboto";
import "@fontsource/inter";
import { MyRides } from "./Home/MyRides/MyRides";
import { SearchRides } from "./Home/SearchRides/SearchRides";
import { HostRide } from "./Home/HostRide/HostRide";
import App from "./Home/Test/Test";
import { Login } from "./Login/Login";
import axios from "axios";
import { SignUp } from "./Login/SignUp/SignUp";

export const axiosApi = axios.create({
  baseURL: "http://192.168.166.234:8080",
});

export const router = createBrowserRouter([
  {
    element: <Root />,
    children: [
      { element: <MyRides />, path: "/home" },
      { element: <SearchRides />, path: "/search" },
      { element: <HostRide />, path: "/newride" },
    ],
  },
  {
    element: <Login />,
    path: "/",
  },
  {
    element: <SignUp />,
    path: "/register",
  },
]);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <RouterProvider router={router} />
);
