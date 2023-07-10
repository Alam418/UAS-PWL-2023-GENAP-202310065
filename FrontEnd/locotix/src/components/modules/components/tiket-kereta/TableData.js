import React from "react";
import { Link } from 'react-router-dom';

export default function TableData({ data }) {
  const JadwalKereta = ({ item }) => {
    const handlePilih = () => {
      localStorage.setItem('asal_kereta', item.asal_kereta);
      localStorage.setItem('tujuan_kereta', item.tujuan_kereta);
      localStorage.setItem('jam_berangkat', item.jam_berangkat);
    };

    return (
      <div className="animate__animated animate__bounce card w-100">
        <div className="container mt-3">
          <img src="https://i.ibb.co/Sr29mJG/R.jpg" className="card-img-top" alt="..." />
        </div>
        <div className="card-body">
          <h5 className="card-title ms-1">{item.asal_kereta} - {item.tujuan_kereta}</h5>
          <p className="card-text mb-5 ms-1">{item.jam_berangkat}</p>
          <Link to="/isi_data" className="btn btn-primary mb-1 mt-1" onClick={handlePilih}>Pilih</Link>
        </div>
      </div>
    );
  };

  return (
    <div className="container">
      <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        {Object.values(data).length > 0 ? (
          data.map((e, index) => (
            <div className="col-2 w-25 my-5" style={{ height: "380px" }} key={index}>
              <JadwalKereta item={e} />
            </div>
          ))
        ) : (
          <div className="col-12">
            <p className="text-dark">No record Found</p>
          </div>
        )}
      </div>
    </div>
  );
}
