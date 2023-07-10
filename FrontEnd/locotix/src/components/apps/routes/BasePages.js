import React from 'react'
import { Route, Routes } from 'react-router-dom'
import { TiketKereta } from '../../modules/components/tiket-kereta/TiketKereta'
// import CekTiket from '../../modules/components/cek-tiket/Cek_tiket'
import IsiData from '../../modules/components/isi-data/Isi_data'
import Pembayaran from '../../modules/components/pembayaran/Pembayaran'
import Contact from '../../modules/components/contact/Contact'


export default function BasePages() {
  return (
    <Routes>
            <Route index element={<TiketKereta />} />
            <Route path='tiket_kereta' element={<TiketKereta />} />
            {/* <Route path='cek_tiket' element={<CekTiket />} /> */}
            <Route path='isi_data' element={<IsiData />} />
            <Route path='pembayaran' element={<Pembayaran />} />
            <Route path='contact' element={<Contact />} />
            {/* <Route path='profile' element={<Profiles />} />
            <Route path='*' element={<Error404 />} />  */}
        </Routes>
  )
}
