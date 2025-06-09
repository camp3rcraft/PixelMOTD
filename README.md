![banner-desc](https://cdn.modrinth.com/data/cached_images/71d5a066be2a8f62309aae9207da1918f5d3fe64_0.webp)
# 📃Custom MOTD for your server
Customize your server description with unlimited HEX colors, and also set your "fake" number of maximum players

**⚠️To run this plugin you must also install the [ForestCore](https://modrinth.com/plugin/forestcore) plugin on your server.**
![Features](https://cdn.modrinth.com/data/cached_images/92674a596935edd1f9c8bf760f86ada63218808a_0.webp)
- HEX Color support
- Custom config.yml
- Very simple and non-loading plugin
- Command for fast-reload configuration - /pmotd reload

![Commands](https://cdn.modrinth.com/data/cached_images/4d90316311426fc113e29fe0b79fee15bdeab81d_0.webp)

`/pmotd reload` - reload configuration

![Configs](https://cdn.modrinth.com/data/cached_images/0e885429a526b89978efec600f3373a142e740cf_0.webp)

**🌈How to create gradient -** https://www.birdflop.com/resources/rgb/

<details>
<summary>config.yml</summary>

```yaml
# PixelMOTD Configuration
# by camper_crafting

# Enable/disable features
features:
  custom-motd: true
  fake-max-players: true

# MOTD settings
motd:
  # You can use HEX colors with #RRGGBB format
  # Example: "&#FF0000Red Text"
  line1: '&#F2C6DEP&#EFC7E0i&#ECC8E3x&#E9C9E5e&#E7CAE7l&#E4CAE9M&#E1CBECO&#DECCEET&#DBCDF0D
    &7| &#5CFAF3Y&#5DEAF4o&#5DDBF5u &#5FBCF6c&#5FACF7a&#609CF8n &#617DF9c&#626DFAo&#625EFBn&#634EFBf&#643FFCi&#642FFDg&#651FFEu&#6510FEr&#6600FFe'
  line2: '&#5CFAF3M&#5DEBF4O&#5DDDF4T&#5ECEF5D &#5FB0F7i&#60A2F7n &#6184F9c&#6176F9o&#6267FAn&#6258FBf&#634AFBi&#643BFCg&#642CFD.&#651DFEy&#650FFEm&#6600FFl'

# Fake max players settings
fake-max-players:
  enabled: true
  # This will only change the displayed number, not the actual server capacity
  max-players: 77
```


</details>

