import React, { Component } from 'react';
import ProductListComponent from '../Component/ProductListComponent'
import PropTypes from 'prop-types'
import axios from 'axios'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import {injector} from 'react-services-injector';
import picture from './samsung.jpg';


class ProductListContainer extends Component {
  constructor(props, context) {
    super(props, context);
    this.handleDetailsClick = this.handleDetailsClick.bind(this);
    this.state = { products: [] };
  }

  componentDidMount() {
    axios.get('https://itpro2017.herokuapp.com/api/products').then((response) => {
      this.setState({ products: response.data });
    });
  }

  handleDetailsClick(productId) {
    return (() => {
      this.context.router.push('/products/' + productId, { id: productId });
    });
  }

  render() {
   
    return (
      <div>
        <ProductListComponent
          products={this.state.products}
          onDetailsClick={this.handleDetailsClick} />
      </div>
    )
  }
}

ProductListContainer.contextTypes = {
  router: PropTypes.object.isRequired,
};

export default ProductListContainer;