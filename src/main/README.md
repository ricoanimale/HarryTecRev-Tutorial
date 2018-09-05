A Minecraft 1.11.2/1.12.2 modding tutorial by HarryTecRev.

This is a basic Minecraft modding tutorial.

This is the general package structure for this mod:

+-main/
      |
      +-java/
      |     |
      |     +-com.richardsearcy.htrtut/
      |             |
      |             +-gen/
      |             |
      |             +-handlers/
      |             |
      |             +-init/
      |             |     |
      |             |     +-armor/
      |             |     |
      |             |     +-blocks/
      |             |     |     |
      |             |     |     +-activators/
      |             |     |     |
      |             |     |     +-fence/
      |             |     |     |
      |             |     |     +-slab/
      |             |     |
      |             |     +-items/
      |             |     |
      |             |     +-tools/
      |             |
      |             +-proxy/
      |             |
      |             +-tabs/
      |             |
      |             +-util/
      |             |
      |             +-Main.java
      |
      +-resources/
           |
           +-assets/
           |     |
           |     +-htrtut/
           |     |     |
           |     |     +-blockstates/
           |     |     |
           |     |     +-lang/
           |     |     |
           |     |     +-models/
           |     |     |     |
           |     |     |     +-block/
           |     |     |     |
           |     |     |     +-item/
           |     |     |
           |     |     +-textures/
           |     |     
           |     +-minecraft/
           |           |
           |           +-textures/
           |                |
           |                +-gui/
           |                     |
           |                     +-container/
           |                          |
           |                          +-creative_inventory/
           |
           +-mcmod.info
           |
           +-pack.mcmeta
  