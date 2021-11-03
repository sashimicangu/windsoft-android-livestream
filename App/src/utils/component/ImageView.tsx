import PropTypes from 'prop-types'
import React from 'react';
import { requireNativeComponent, ViewPropTypes } from 'react-native'

const RCTImageViewComponent = requireNativeComponent('RCTMyImageView');

const MyImageView = (props: any) => {
  return <RCTImageViewComponent {...props} />
}

export default MyImageView
