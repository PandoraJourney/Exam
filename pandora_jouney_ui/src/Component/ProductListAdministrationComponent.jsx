import React, { Component } from 'react'
import { Link } from 'react-router'
import PropTypes from 'prop-types'


class ProductListAdministrationComponent extends Component {
  constructor(context){
    super(context);
  }
  
  render() {
    var itemsHtml = this.props.products.map((item, index) => {
      var url = '/admin/products/' + item.id;
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
        <Link className="btn btn-success" to='/admin/products/new'>Add new product</Link>
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
}
ProductListAdministrationComponent.propTypes = {
  products: PropTypes.array.isRequired,
  
};

export default ProductListAdministrationComponent;
