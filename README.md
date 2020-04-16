# react-native-tiff-library

## Getting started

`$ npm install react-native-tiff-library --save`

### Mostly automatic installation

`$ react-native link react-native-tiff-library`

### Add manually

Add the following dependency into you `package.json` file under "dependencies":

```{json}
"dependencies": {
    "react-native-tiff-library": "git+https://github.com/aantonello/react-native-tiff-library.git"
}
```

## Usage
```javascript
import TiffLibrary from 'react-native-tiff-library';

// TODO: What to do with the module?
TiffLibrary.tiffToPng('base 64 tiff image', (base64Result) => {
  // Result is base 64 PNG image. Only the first image of tiff file is converted.
});
```
