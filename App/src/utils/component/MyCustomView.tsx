import React, { Component } from 'react'
import { requireNativeComponent, Text, View } from 'react-native'

class MyCustomView extends Component {
  constructor(props: any) {
    super(props)
    this._onChange = this._onChange.bind(this)
  }
  _onChange(event: Event) {
    console.log('heher!')

    if (!this.props.onChangeMessage) {
      return
    }
    this.props.onChangeMessage(event.nativeEvent.message)
  }
  render() {
    return <RCTMyCustomView {...this.props} onChange={this._onChange} />
  }
}

MyCustomView.propTypes = {
  /**
   * Callback that is called continuously when the user is dragging the map.
   */
  onChangeMessage: PropTypes.func,
}

var RCTMyCustomView = requireNativeComponent(`RCTImageView`)
