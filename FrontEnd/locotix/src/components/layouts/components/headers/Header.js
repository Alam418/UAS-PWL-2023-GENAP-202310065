import React from 'react'
import { NavLink } from 'react-router-dom';
import './../../../../index.css';

export default function HeaderNav() {
    
    const menuList = [{ id: 1, name: "Tiket Kereta", path: "/tiket_kereta", icon:"bi-train-front" },
                    //   { id: 2, name: "Cek Tiket", path: "/cek_tiket", icon:"bi-ticket-perforated" },
                      { id: 3, name: "Contact", path: "/contact", icon:"bi-telephone" },];
    return (
        <header>
            <nav className="navbar navbar-expand-md h-8 fixed-top shadow nav-bg">
                <div className="container">
                    <a className="navbar-brand" href="/">
                        <img src={require("../../../../components/assets/media/banner.png")} alt="ibik-logo" 
                        style={{ height: "200px" }} />
                    </a>
                    <button className="navbar-toggler" type="button">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarCollapse">
                        <div className="d-flex w-100 justify-content-end">
                            <div id='main-nav'>
                                <ul className="navbar-nav me-auto mb-2 mb-md-0">
                                    {menuList.map((v, index) => (
                                        <li className="nav-item me-1" key={index}>
                                            <NavLink className="nav-link text-hover-primary text-white px-3" to={v.path}>
                                                <i className={"bi me-2 fs-5 text- "+v.icon}></i>
                                                {v.name}
                                            </NavLink>
                                        </li>
                                    ))}
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
    )
}