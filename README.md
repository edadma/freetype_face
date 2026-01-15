freetype_face
=============

Shared `FT_Face` type definition for FreeType Scala Native bindings.

This package exists to allow multiple libraries to share the `FT_Face` type without circular dependencies. For example, both the `freetype` bindings and `libcairo` bindings need to work with `FT_Face` pointers.

Installation
------------

Add the dependency to your `build.sbt`:

```scala
libraryDependencies += "io.github.edadma" %%% "freetype_face" % "0.0.2"
```

Usage
-----

```scala
import io.github.edadma.freetype_face.FT_Face

// FT_Face is defined as:
// type FT_Face = Ptr[CStruct0]
```

This type is used by:
- [freetype](https://github.com/edadma/freetype) - FreeType bindings
- [libcairo](https://github.com/edadma/libcairo) - Cairo graphics bindings

License
-------

ISC
