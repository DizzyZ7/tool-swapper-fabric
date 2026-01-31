![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21+-62B246?style=for-the-badge&logo=minecraft&logoColor=white)
![Loader](https://img.shields.io/badge/Loader-Fabric-f0d2b4?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=openjdk&logoColor=white)

# ⛏️ Tool Swapper (Fabric)

Developed by **DizzyZ7**.

A smart utility mod that automatically switches your active hotbar slot to the most effective tool for the block you are looking at.

## ✨ Features
* **⚡ Instant Swap:** Switches to the best tool (Pickaxe, Axe, Shovel, or Hoe) as soon as you start mining.
* **🔍 Smart Analysis:** Compares `MiningSpeedMultiplier` across all hotbar items to find the absolute best tool.
* **🛡️ Item Protection:** Does not swap if you are in Creative or Spectator mode.
* **🎯 Minimalist:** No complex UI — it just works in the background.

## 🛠️ Technical Details
* **Callbacks:** Implements `AttackBlockCallback` to intercept player interactions.
* **Logic:** Efficiently iterates through the player's hotbar (0-8) without scanning the entire inventory, saving processing power.
* **API:** Leverages Minecraft's internal `isSuitableFor` methods for 100% accuracy with any block type.
