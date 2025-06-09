# PixelMOTD

A flexible Minecraft Paper plugin for customizing your server's MOTD with HEX colors and fake player count.

## Features

- Custom MOTD with HEX color support
- Fake max players count
- ForestCore integration
- Easy configuration
- Reload command

## Requirements

- Paper/Spigot 1.16.5 or higher
- ForestCore 1.0-SNAPSHOT or higher

## Installation

1. Download the latest release from [Releases](https://github.com/camp3rcraft/PixelMOTD/releases)
2. Place `PixelMOTD.jar` in your server's `plugins` folder
3. Make sure ForestCore is installed
4. Start or reload your server

## Configuration

The plugin creates a `config.yml` file in the `plugins/PixelMOTD` folder. Here's an example configuration:

```yaml
# Enable or disable features
features:
  custom-motd: true
  fake-max-players: true

# MOTD configuration
motd:
  line1: "&#F2C6DEp&#EFC7E0i&#ECC8E3x&#E9C9E5e&#E7CAE7l&#E4CAE9M&#E1CBECO&#DECCEET&#DBCDF0D"
  line2: "&#5CFAF3M&#5DEBF4O&#5DDDF4T&#5ECEF5D &#5FB0F7i&#60A2F7n &#6184F9c&#6176F9o&#6267FAn&#6258FBf&#634AFBi&#643BFCg&#642CFD.&#651DFEy&#650FFEm&#6600FFl"

# Fake max players configuration
fake-max-players:
  max-players: 77
```

### HEX Colors

The plugin supports HEX colors in the format `&#RRGGBB`. For example:
- `&#FF0000` - Red
- `&#00FF00` - Green
- `&#0000FF` - Blue

You can use online color pickers to find your desired colors.

## Commands

- `/pixelmotd reload` - Reload the plugin configuration

## ForestCore Integration

PixelMOTD integrates with ForestCore to provide a better user experience:
- Plugin information in ForestCore menu
- Version compatibility check
- Unified command system

[SCREENSHOT: ForestCore menu showing PixelMOTD information]

## Building from Source

1. Clone the repository:
```bash
git clone https://github.com/camp3rcraft/PixelMOTD.git
```

2. Build with Maven:
```bash
cd PixelMOTD
mvn clean package
```

The compiled plugin will be in the `target` folder.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

If you need help or have suggestions, please:
1. Check the [Issues](https://github.com/camp3rcraft/PixelMOTD/issues) page
2. Create a new issue if your problem hasn't been reported
3. Join our [Discord server](https://discord.gg/your-discord) for real-time support

## Screenshots

[SCREENSHOT: Server list showing custom MOTD with gradient colors]
[SCREENSHOT: Plugin configuration in ForestCore menu]
[SCREENSHOT: Example of different MOTD styles] 