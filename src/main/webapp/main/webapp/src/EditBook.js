import React, { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import MyTextInput from "./MyTextInput";
import axios from "axios";
import classnames from "classnames";
import { useParams, useNavigate } from "react-router-dom";

function EditBook() {
  const [state, setState] = useState({
    bookId: 0,
    bookName: "",
    author: "",
    price: 0,
    category: "",
    publications: "",
    errors: {},
  });

  const { mybookId } = useParams();
  const history = useNavigate();

  useEffect(() => {
    console.log("componentDidMount", mybookId); // Should log the mybookId passed in the URL

    const URL = `http://localhost:5500/myapi/mybooks/${mybookId}`;
    axios.get(URL).then((myresponse) => {
      console.log(myresponse.data);
      setState({
        bookId: myresponse.data.bookId,
        bookName: myresponse.data.bookName,
        author: myresponse.data.author,
        price: myresponse.data.price,
        category: myresponse.data.category,
        publications: myresponse.data.publications,
        errors: {},
      });
    });
  }, [mybookId]);

  const onChangeHandler = (event) => {
    console.log("onChangeHandler");
    setState({
      ...state,
      [event.target.name]: event.target.value,
    });
  };

  const onSubmitHandler = (event) => {
    event.preventDefault();
    const { bookName, author, price, category, publications } = state;
    console.log("onSubmitHandler");
    console.log(state);

    // Do the Validations
    if (bookName === "") {
      setState({
        ...state,
        errors: { bookName: "Book Name is Required" },
      });
      return;
    }

    if (author === "") {
      setState({
        ...state,
        errors: { author: "Author is Required" },
      });
      return;
    }

    if (price === "") {
      setState({
        ...state,
        errors: { price: "Price is Required" },
      });
      return;
    }

    if (category === "") {
      setState({
        ...state,
        errors: { category: "Category is Required" },
      });
      return;
    }

    if (publications === "") {
      setState({
        ...state,
        errors: { publications: "Publications is Required" },
      });
      return;
    }

    // Make Call to Server
    const URL = "http://localhost:5500/myapi/mybooks";
    axios.put(URL, state)
      .then((myresponse) => {
        console.log(1, myresponse.data);
        // Form Reset
        setState({
          bookId: 0,
          bookName: "",
          author: "",
          price: 0,
          category: "",
          publications: "",
          errors: {},
        });
        history('/');
      })
      .catch((myerror) => {
        console.log(2, myerror);
      });
  };

  const { bookId, bookName, author, price, category, publications } = state;
  return (
    <div className="card-body container col-md-6">
      <h2 className="text-center"> Edit Book Form </h2>
      <form onSubmit={onSubmitHandler}>
        <div className="form-group">
          <label htmlFor="bookId"> Book Id </label>
          <input
            type="text"
            name="bookId"
            value={bookId}
            readOnly
            className={classnames("form-control form-control-lg")}
          />
        </div>
        <MyTextInput
          myname="bookName"
          mylabel="Book Name"
          myvalue={bookName}
          myerror={state.errors.bookName}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="author"
          mylabel="Author"
          myvalue={author}
          myerror={state.errors.author}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="price"
          mylabel="Price"
          myvalue={price}
          myerror={state.errors.price}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="category"
          mylabel="Category"
          myvalue={category}
          myerror={state.errors.category}
          myOnChange={onChangeHandler}
        />
        <MyTextInput
          myname="publications"
          mylabel="Publications"
          myvalue={publications}
          myerror={state.errors.publications}
          myOnChange={onChangeHandler}
        />
        <input
          type="submit"
          value="Update Book Now"
          className="btn btn-primary btn-lg"
        />
      </form>
    </div>
  );
}

export default EditBook;
