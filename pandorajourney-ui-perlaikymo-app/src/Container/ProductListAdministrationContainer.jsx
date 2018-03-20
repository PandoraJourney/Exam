import React, {Component} from 'react'
import ProductListAdministrationComponent from '../Component/ProductListAdministrationComponent'
import PropTypes from 'prop-types'
import axios from 'axios'
import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';


class ProductListAdministrationContainer extends Component{
    
     constructor(context) {
        super(context)
        this.state = { services: [],
                        providers:[] };
      }
    
      componentWillMount() {
        axios.get('https://localhost:808/services').then((response) => {
          this.setState(()=>{return{ services: response.data} });
        });
        axios.get('https://localhost:808/providers').then((response) => {
          this.setState(()=>{return{ providers: response.data} });
        });
      }
    
      render() {
        return (
          <div>
            <table className="table">
                      <thead>
                        <tr>
                          <th>Services</th>
                          <th>Providers</th>
                        </tr>
                      </thead>
                      <tbody>
                      <tr>
                          <td><ProductListAdministrationComponent products={this.state.service} button={"Add service"} /></td>
                        <td><ProductListAdministrationComponent products={this.state.providers} button={"Add provider"} /></td>
                        </tr>
                  
                      </tbody>
                    </table>
            </div>
        );
      }
    }
    
    ProductListAdministrationComponent.contextTypes = {
      router: PropTypes.object.isRequired,
    };
    
export default ProductListAdministrationContainer;