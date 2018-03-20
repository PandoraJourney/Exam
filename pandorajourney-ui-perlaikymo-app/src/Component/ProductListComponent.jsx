import React, { Component } from 'react'
import PropTypes from 'prop-types'
import {Link} from 'react-router'
import ProductCardComponent from './ProductCardComponent'


class ProductListComponent extends Component {
    render() {
        if (this.props.products.length !== 0) {
            // var productCards = this.props.products.map((product, index) => {
            //     return (
            //         <ProductCardComponent
            //             key={index}
            //             id={product.id}
            //             image={product.image}
            //             title={product.title}
            //             description={product.description}
            //             price={product.price}
            //             onDetailsClick={this.props.onDetailsClick} />
            //     );
            // });
            // var services = this.props.products.map((service, index))
            // return (<div className="row">{productCards}</div>);
                var itemsHtml = this.props.products.map((item, index) => {
                  var url = '/services/' + item.id;
                  return (
                    <tr key={index}>
                      <td>{index + 1}</td>
                      {/* <td><img src={item.image} /></td> */}
                      <td><Link to={url}>{item.title}</Link></td>
                    </tr>
                  );
                });
                console.log(this.context)
                return (
                  <div>
                    <table className="table">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Title</th>
                        </tr>
                      </thead>
                      <tbody>
                        {itemsHtml}
                      </tbody>
                    </table>
                  </div>
                  );
                }
        else {
            return (<div> Laukiu duomenu </div>);
        }
    }

}

ProductListComponent.propTypes = {
    products: PropTypes.array.isRequired,
    onDetailsClick: PropTypes.func.isRequired,
};

export default ProductListComponent;