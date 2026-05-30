import React, { Component } from "react"; 
 
import { Route, Routes } from "react-router-dom"; 
import AddBook from "./AddBook"; 
import BooksList from "./BooksList"; 
import EditBook from "./EditBook"; 
 
class JLCBody extends Component { 
  render() { 
    return ( 
        <div> 
          <Routes>
            <Route path="/" element={<BooksList />} /> 
            <Route path="/add-book" element={<AddBook />} /> 
            <Route path="/edit-book/:mybookId" element={<EditBook />} /> 
          </Routes>
        </div> 
    ); 
  } 
} 
export default JLCBody; 
