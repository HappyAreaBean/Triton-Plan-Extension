# Triton Plan Extension

This repository contains the source code for the Triton Plan Extension, which integrates with the Triton plugin and
provides additional data to the Plan API.

## Showcase

![image](https://image.happyareabean.cc/u/QzC1VPY6lBEi6eIc.jpg)

## Description

The Triton Plan Extension allows you to gather information about players' languages using the Triton plugin. It extends
the Plan API by adding new data points related to language preferences.

## Features

- **Language Data**: Provides the current language code and display name of a player.
- **Language Change Listener***: Automatically update data when player changed their language.
- **Capability Listener**: Registers an enabled listener to initialize the extension when Triton is enabled.

*Not available in Velocity at the moment, since there are not event for player language change yet.

## Usage

1. Ensure that the Triton plugin and Plan plugin is enabled on your server.
2. The extension will automatically register itself and start collecting data when Triton is initialized.

## Building The Project

Before you begin, ensure you have the following:

- JDK 11+
- Maven installed

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/happyareabean/Triton-Plan-Extension.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Triton-Plan-Extension
   ```

3. Build the project using Maven:
   ```bash
   mvn clean package
   ```

4. Copy the generated JAR file from `target` to your server's plugins directory.

## Contributing

If you want to contribute to this project, feel free to open an issue or submit a pull request!

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

- [DataExtension API Documentation](https://github.com/plan-player-analytics/Plan/wiki/APIv5)