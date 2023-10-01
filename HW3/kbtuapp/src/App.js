import logo from './logo.svg';
import './App.css';
import React, { useContext } from 'react';
import ProductList from './ProductList';
import Cart from './Cart';
import { ProductContext } from './ProductContext';
import { CartContext } from './CartContext';

function App() {

  const { products } = useContext(ProductContext);
  const { cart } = useContext(CartContext);


  return (
    <div>
      <h1>Интернет-магазин</h1>
      <ProductList />
      <Cart />
    </div>
  );
}

export default App;
