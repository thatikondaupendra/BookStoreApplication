import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import MyTextInput from './MyTextInput';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddBook = () => {
  const [bookId, setBookId] = useState(0);
  const [bookName, setBookName] = useState('');
  const [author, setAuthor] = useState('');
  const [price, setPrice] = useState(0);
  const [category, setCategory] = useState('');
  const [publications, setPublications] = useState('');
  const [errors, setErrors] = useState({});
  
  const navigate = useNavigate();

  const onChangeHandler = (event) => {
    const { name, value } = event.target;
    setErrors((prevErrors) => ({ ...prevErrors, [name]: '' })); // Clear error on change

    switch (name) {
      case 'bookName':
        setBookName(value);
        break;
      case 'author':
        setAuthor(value);
        break;
      case 'price':
        setPrice(value);
        break;
      case 'category':
        setCategory(value);
        break;
      case 'publications':
        setPublications(value);
        break;
      default:
        break;
    }
  };

  const onSubmitHandler = async (event) => {
    event.preventDefault();

    // Validation
    const newErrors = {};
    if (bookName === '') newErrors.bookName = "Book Name is Required";
    if (author === '') newErrors.author = "Author is Required";
    if (price <= 0) newErrors.price = "Price must be greater than 0";
    if (category === '') newErrors.category = "Category is Required";
    if (publications === '') newErrors.publications = "Publications is Required";

    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    try {
      // Fetch maxId
      const maxIdResponse = await axios.get(`http://localhost:5500/myapi/maxId`);
      const maxId = maxIdResponse.data[0].bookId + 1; // Increment maxId
      setBookId(maxId);
      console.log("bookName=",maxIdResponse.data[0].bookName)

      // Prepare book data
      const bookData = {
        bookId: maxId,
        bookName,
        author,
        price,
        category,
        publications
      };
      alert(bookData.bookName);
      console.log("BBB",bookData);
      // Post book data
      try {
        const response = await axios.post("http://localhost:5500/myapi/mybooks", bookData);
        console.log("Book:", response.data);
        alert("Book Added Successfully");
      } catch (error) {
        console.error("Error adding book:", error);
      }
      console.log("Book added successfully");
    

      // Reset form
      setBookId(0);
      setBookName('');
      setAuthor('');
      setPrice(0);
      setCategory('');
      setPublications('');
      setErrors({});

      // Navigate to home
      navigate("/");
    } catch (error) {
      console.error("Error adding book:", error);
    }
  };

  return (
    <div className="card-body container col-md-6">
      <h2 className="text-center">Add Book Form</h2>
      <form onSubmit={onSubmitHandler}>
        <MyTextInput
          myname="bookName"
          mylabel="Book Name"
          myvalue={bookName}
          myerror={errors.bookName}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="author"
          mylabel="Author"
          myvalue={author}
          myerror={errors.author}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="price"
          mylabel="Price"
          myvalue={price}
          myerror={errors.price}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="category"
          mylabel="Category"
          myvalue={category}
          myerror={errors.category}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="publications"
          mylabel="Publications"
          myvalue={publications}
          myerror={errors.publications}
          myOnChange={onChangeHandler}
        />
        <input
          type="submit"
          value="Add Book Now"
          className="btn btn-primary btn-lg"
        />
      </form>
    </div>
  );
};

export default AddBook;