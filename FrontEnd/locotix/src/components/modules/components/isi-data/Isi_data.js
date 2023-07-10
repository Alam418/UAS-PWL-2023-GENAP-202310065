import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function Isi_data() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: '',
    nik: '',
    no_hp: '',
    alamat: '',
    email: '',
    pd: '',
    pb: '',
    tgl_pemesanan: '',
    jenis_Kereta: '',
    harga: '',
    kereta: '',
    jadwal: ''
  });

  const asal = localStorage.getItem('asal_kereta');
  const tujuan = localStorage.getItem('tujuan_kereta');
  const waktu = localStorage.getItem('jam_berangkat');

  const handleChange = (event) => {
    const { name, value } = event.target;

    let harga = '';

    if (name === 'jenis_Kereta') {
      if (value === 'Kereta Ekonomi') {
        harga = '45000';
      } else if (value === 'Kereta Bisnis') {
        harga = '80000';
      }
    }

    let pd = formData.pd;
    if (name === 'pd') {
      pd = value;
      document.getElementsByName('jumlah_pd')[0].textContent = value;
    }

    // let pb = formData.pb;
    // if (name === 'pb') {
    //   pb = value;
    //   document.getElementsByName('jumlah_pb')[0].textContent = value;
    // }

    const totalHarga = parseInt(pd) * parseInt(harga) + 7500;

    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
      harga: totalHarga,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/api/tiket', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          ...formData,
          kereta: asal+ ' - ' +tujuan,
          jadwal: waktu,
        }),
      });

      const jsonData = await response.json();
      console.log(jsonData);
      localStorage.setItem('harga', formData.harga);
      navigate('/pembayaran');
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="container mt-5">
      {/* <h2>Pesan tiket kereta {asal}-{tujuan}</h2> */}
      <div className="container">
        <form onSubmit={handleSubmit}>
          <div className="row">
            <div className="col-md-8">
              <h2>Detail Pemesan</h2>
              <div className="card">
                <div className="card-body">
                  <div className="row">
                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label htmlFor="name">Tuan/Nyonya</label>
                        <input
                          type="text"
                          className="form-control"
                          id="name"
                          name="name"
                          value={formData.name}
                          onChange={handleChange}
                          placeholder=""
                        />
                      </div>
                    </div>

                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label htmlFor="email">Email</label>
                        <input
                          type="text"
                          className="form-control"
                          id="email"
                          name="email"
                          value={formData.email}
                          onChange={handleChange}
                          placeholder=""
                        />
                      </div>
                    </div>
                  </div>

                  <div className="row">
                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label htmlFor="nik">NIK</label>
                        <input
                          type="text"
                          className="form-control"
                          id="nik"
                          name="nik"
                          value={formData.nik}
                          onChange={handleChange}
                          placeholder=""
                        />
                      </div>
                    </div>

                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label htmlFor="no_hp">Nomor Telepon Pemesan</label>
                        <input
                          type="text"
                          className="form-control"
                          id="no_hp"
                          name="no_hp"
                          value={formData.no_hp}
                          onChange={handleChange}
                          placeholder=""
                        />
                      </div>
                    </div>
                  </div>

                  <div className="row">
                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label htmlFor="alamat">Alamat</label>
                        <input
                          type="text"
                          className="form-control"
                          id="alamat"
                          name="alamat"
                          value={formData.alamat}
                          onChange={handleChange}
                          placeholder=""
                        />
                      </div>
                    </div>

                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label htmlFor="tgl_pemesanan">
                          Tanggal Keberangkatan
                        </label>
                        <input
                          type="date"
                          className="form-control"
                          id="tgl_pemesanan"
                          name="tgl_pemesanan"
                          value={formData.tgl_pemesanan}
                          onChange={handleChange}
                          placeholder=""
                          pattern="\d{4}-\d{2}-\d{2}"
                          required
                        />
                      </div>
                    </div>
                  </div>

                </div>
              </div>
            </div>
            <div className="col-md-4">
              <h2>Detail Biaya</h2>
              <div className="card">
                <div className="card-body">
                  <div className="row">
                    <div className="col-8">
                      <h5 className="card-title mt-1">Harga</h5>
                      <p className="card-text">Dewasa x1</p>
                      <p className="card-text">Bayi x1</p>
                      <p className="card-text">Biaya Layanan</p>
                      <p className="card-text">Biaya Jasa</p>
                      <p className="card-text">Kereta</p>
                    </div>
                    <div className="col">
                      <br />
                      <br />
                      <p className="card-text" name="jumlah_pd">0</p>
                      <p className="card-text" name="jumlah_pb">0</p>
                      <p className="card-text">Rp. 7.500</p>
                      <p className="card-text text-success">
                        <b>Gratis</b>
                      </p>
                      <p>{asal} - {tujuan} | {waktu}</p>
                    </div>
                  </div>
                  <hr />
                  <div className="row">
                    <div className="col-7">
                      <p className="card-text">Pajak</p>
                      <p className="card-text">Total Pembayaran</p>
                    </div>
                    <div className="col">
                      <p className="card-text"><b>Sudah Termasuk</b></p>
                      <input
                        type="text"
                        className="form-control card-text border-0 bg-white w-50"
                        id="harga"
                        name="harga"
                        value={formData.harga}
                        onChange={handleChange}
                        placeholder=""
                        readOnly
                        disabled
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="row mt-5">
            <div className="col-md-8">
              <h2>Detail Penumpang</h2>
              <div className="card">
                <div className="card-body">
                  <div className="row">
                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label >Penumpang Dewasa <br /> <small className='text-secondary'>Usia &gt; 3 tahun</small></label>
                        <input type="text"
                          className="form-control"
                          id="pd"
                          name="pd"
                          value={formData.pd}
                          onChange={handleChange}
                          placeholder="" />
                      </div>
                    </div>

                    <div className="col-md-6 my-2">
                      <div className="form-group">
                        <label >Penumpang Bayi <br /> <small className='text-secondary'>Usia &lt; 3 tahun</small></label>
                        <input type="text"
                          className="form-control"
                          id="pb"
                          name="pb"
                          value={formData.pb}
                          onChange={handleChange}
                          placeholder="" />
                      </div>
                    </div>
                  </div>
                  <div className="row">
                    <div className=" my-2">
                      <div className="form-group">
                        <label htmlFor="jenisKereta">Jenis Kereta</label>
                        <select
                          className="form-control"
                          id="jenisKereta"
                          name="jenis_Kereta"
                          onChange={handleChange}
                          value={formData.jenis_Kereta}
                        >
                          <option value="">Pilih Jenis Kereta</option>
                          <option value="Kereta Ekonomi">Kereta Ekonomi</option>
                          <option value="Kereta Bisnis">Kereta Bisnis</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          {/* <Link>| */}
          <button type="submit" className="btn btn-primary mt-3">Submit</button>
          {/* </Link> */}
        </form>
      </div>
    </div>
  )
}