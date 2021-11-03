import React from 'react'
import {
  requireNativeComponent,
  SafeAreaView,
  StyleSheet,
  Text,
  useColorScheme,
} from 'react-native'
import MyImageView from './src/utils/component/ImageView'

const App = () => {
  const isDarkMode = useColorScheme() === 'dark'

  return (
    <SafeAreaView style={{ flex: 1 }}>
      <Text children={'hello'} />
      <MyImageView
        src={'Hello cac ban'}
        resizeMode="cover"
        style={{ height: 50, backgroundColor: 'yellow' }}
      />
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
})

export default App
