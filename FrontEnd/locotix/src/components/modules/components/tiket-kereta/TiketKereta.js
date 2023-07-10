import React, { useState, useEffect } from 'react'
import CallAxios from '../Library/CallAxios';
import TableData from './TableData';

export function TiketKereta() {
  const [showCard, setShowCard] = useState(false);
  const [listJadwal, setListJadwal] = useState("");

  const [paramJadwal, setParamJadwal] = useState({
    loading: false,
    data: [],
    message: "",
  });

  const GET_ALL = () => {
    setParamJadwal({ ...paramJadwal, loading: true });
    const postData = {
      method: "GET",
      url: "http://localhost:8080/api/jadwal",
      headers: { 'Content-Type': 'application/json' }
    };
    CallAxios(postData).then((response) => {
      console.log(response);
      if (response.error) {
        setParamJadwal({ ...paramJadwal, loading: false, message: response.error });
      } else {
        let results = response.data;
        if (results) {
          setListJadwal(results)
          setParamJadwal({ ...paramJadwal, loading: false, message: "", data: results });
        } else {
          setParamJadwal({ ...paramJadwal, loading: false, message: "No record found" });
        }
      }
    })
  };

  useEffect(() => {
    GET_ALL();
  }, []);

  const handleSearch = () => {
    setShowCard(true);
  };

  return (
    <div className='container mt-5'>
      <div className="card blueish-bg text-white">
        <div className="card-body">
          <h5 className="card-title mb-5 text-white ">Pemesanan Tiket Kereta Api</h5>

          <form className="row mb-3 fs-5" action="">
            <div className="col">
              <label className="form-label text-white">Dari</label>
              <input
                type="text"
                name="search"
                className="form-control"
                placeholder="Search here"
                autoComplete="off"
              />
            </div>
            <div className="col">
              <label className="form-label text-white">Ke</label>
              <input className="form-control" type="text" />
            </div>
          </form>
          <div className='d-grid gap-2'>
            <button className='btn btn-sm green-btn fs-5 w-100 text-white' onClick={handleSearch}>Cari</button>
          </div>
        </div>
      </div>

      {showCard && (
        <div className="mt-5 d-flex flex-row justify-content-between">
          <TableData data={listJadwal} />
        </div>
      )}


    </div>
  )
}