<a id="readme-top"></a>



<!-- PROJECT LOGO -->
<br />
<div align="center">
  
  <!-- PROJECT SHIELDS -->
  [![Contributors][contributors-shield]][contributors-url]
  [![Forks][forks-shield]][forks-url]
  [![Stargazers][stars-shield]][stars-url]
  [![Issues][issues-shield]][issues-url]

<pre>
 __      __         .____                  __    __________.__               _________              
/  \    /  \ ____   |    |    ____  ______/  |_  \__    ___|  |__   ____    /   _____/ ____ _____   
\   \/\/   _/ __ \  |    |   /  _ \/  ___\   __\   |    |  |  |  \_/ __ \   \_____  \_/ __ \\__  \  
 \        /\  ___/  |    |__(  <_> \___ \ |  |     |    |  |   Y  \  ___/   /        \  ___/ / __ \_
  \__/\  /  \___  > |_______ \____/____  >|__|     |____|  |___|  /\___  > /_______  /\___  (____  /
       \/       \/          \/         \/                       \/     \/          \/     \/     \/ 
</pre> 

  <p align="center">
    A text adventure game where players embark on a journey filled with challenges and exploration.
    <br />
    <a href="https://github.com/AfonsoBatista7/WeLostTheSea"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/AfonsoBatista7/WeLostTheSea/issues">Report Bug</a>
    ·
    <a href="https://github.com/AfonsoBatista7/WeLostTheSea/issues">Request Feature</a>
  </p>


</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#compile">Compile</a></li>
        <li><a href="#configuration">Configuration</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

[![Java][java-shield]][java-url]
[![Maven][maven-shield]][maven-url]

---

## 🧩 About The Project

WeLostTheSea is a text adventure game that allows players to explore a rich narrative world, make choices, and interact with various characters and objects. The game is designed to provide an engaging experience through storytelling and decision-making.

### Key Features:
- Interactive text-based gameplay with multiple choices.
- Dynamic dialogue system with NPC interactions.
- Inventory management for items collected during the adventure.
- Save and load game functionality to track progress.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🚀 Getting Started

Follow these steps to compile and run the WeLostTheSea game on your local machine.

### ✅ Prerequisites

- Java 8 or higher
- Maven (for building the project)
- A compatible IDE (e.g., IntelliJ IDEA, Eclipse) for development

## 📥 Downloading the Latest Release

To download the latest release of the WeLostTheSea game, follow these steps:

1. **Visit the Releases Page**:
   Go to the [Releases](https://github.com/AfonsoBatista7/WeLostTheSea/releases) page of the repository.

2. **Download the Latest Release**:
   Find the latest release and download the `.jar` file. It will be named something like `WeLostTheSea-1.0-SNAPSHOT.jar`.

3. **Run the Game**:
   After downloading the JAR file, you can run it using the following command in your terminal:
   ```bash
   java -jar path/to/WeLostTheSea-<release-version>.jar
   ```
   Replace `path/to/` with the actual path where you saved the JAR file and `release-version` with the downloaded release version.

4. **Follow On-Screen Prompts**:
   Once the game starts, follow the on-screen prompts to navigate through the adventure.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### 💾 Compile

1. **Clone the repository**:
   ```bash
   git clone https://github.com/AfonsoBatista7/WeLostTheSea.git
   cd WeLostTheSea
   ```
2. **Build the project**:
   ```bash
   mvn clean package
   ```
3. Find the built .jar file in the `target/` folder.

4. Run the game using the command:
   ```bash
   java -jar target/WeLostTheSea-1.0-SNAPSHOT.jar
   ```

## 🛠️ Usage

- Start the game and follow the on-screen prompts to navigate through the adventure.
- Make choices that affect the outcome of the story.
- Collect items and manage your inventory as you progress.

### 📋 Commands

| Command                                | Description                                              |
|----------------------------------------|----------------------------------------------------------|
| `START`                                | Starts the game.                                        |
| `INF`                                  | Provides information about the game.                    |
| `LOCATION`                             | Displays the name of your current location.             |
| `BAG`                                  | Opens your inventory bag.                               |
| `GET <item>`                           | Collects an item from the ground.                       |
| `DROP <item>`                          | Drops an item from your inventory.                      |
| `SAVE`                                 | Saves your current game state.                          |
| `LOAD`                                 | Loads a previously saved game state.                    |
| `EXIT`                                 | Exits the game.                                        |

<p align="right">(<a href="#readme-top">back to top</a>)</p>

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork this repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/my-feature
   ```
3. Make your changes and commit:
   ```bash
   git commit -m 'Add some feature'
   ```
4. Push to your branch:
   ```bash
   git push origin feature/my-feature
   ```
5. Open a pull request.

Please ensure your code follows good practices and includes a clear description of your changes.

## 📬 Contact

- Discord: [0xrage](https://www.discordapp.com/users/0xrage)
- Email: [afonsobatista13@gmail.com](mailto:afonsobatista13@gmail.com)
- GitHub: [AfonsoBatista7](https://github.com/AfonsoBatista7/WeLostTheSea)

---

Made with ❤️ for text adventure game enthusiasts :DD

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
<!-- From own repo -->
[contributors-shield]: https://img.shields.io/github/contributors/AfonsoBatista7/WeLostTheSea.svg?style=for-the-badge
[contributors-url]: https://github.com/AfonsoBatista7/WeLostTheSea/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/AfonsoBatista7/WeLostTheSea.svg?style=for-the-badge
[forks-url]: https://github.com/AfonsoBatista7/WeLostTheSea/network/members
[issues-shield]: https://img.shields.io/github/issues/AfonsoBatista7/WeLostTheSea.svg?style=for-the-badge
[issues-url]: https://github.com/AfonsoBatista7/WeLostTheSea/issues
[license-shield]: https://img.shields.io/github/license/AfonsoBatista7/WeLostTheSea.svg?style=for-the-badge
[license-url]: https://github.com/AfonsoBatista7/WeLostTheSea/blob/master/LICENSE.txt
[stars-shield]: https://img.shields.io/github/stars/AfonsoBatista7/WeLostTheSea.svg?style=for-the-badge
[stars-url]: https://github.com/AfonsoBatista7/WeLostTheSea/stargazers
<!-- From repo images -->
[product-screenshot]: ./docs/images/product.png
<!-- From badges -->
[java-shield]: https://img.shields.io/badge/Java-FF0000?logoColor=white
[java-url]: https://openjdk.org/
[maven-shield]: https://img.shields.io/badge/Maven-purple?logoColor=white
[maven-url]: https://maven.apache.org/

