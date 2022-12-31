Pour l'application 

Déjà il faut créer une bdd et aussi
back_end_db et aussi modifier l'uri dans application.properties qui est dans ressources

Et créer dans cette bdd une collection roles et y mettre 
````json
{
  "_id": {
    "$oid": "63adb6aa3c7fbbb5d9f62074"
  },
  "name": "ROLE_USER"
}
````
C'est le seul role autoriser pour le jwt que nous avons créer 
les endpoints

Post http://localhost:8080/api/auth/signup

Body
 ````json
{
    "username": "test",
    "email": "aristide.ff@gmail.com",
    "roles": [
        "ROLE_USER"
    ],
    "password": "testt"
    
}
````
Response

```json
{
    "message": "User registered successfully!"
}
```

Post http://localhost:8080/api/auth/signin

Body
````json
{
    "username": "test",
    "password":"testt"
}
````

Response

```json
{
    "id": "63adbc3b2fddf2119c08c92b",
    "username": "test",
    "email": "aristide.ff@gmail.com",
    "roles": [
        "ROLE_USER"
    ],
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNjcyMzMwMzQzLCJleHAiOjE2NzI0MTY3NDN9.QhEdkjsNa-Tb0Wqta2S2yrwwdnN_t_8ADMKvOKhPKdD2KWG-pvqYKggmiVuoeuPYdr7S7uzx6EtiHd_vgKQ_KA",
    "tokenType": "Bearer"
}
```

POST  http://localhost:8080/api/auth/lost

Body
````json
{
    "email": "aristide.ff@gmail.com"
}
````

Reponse

````json
{
    "message": "Password change default"
}
````
Pour simplifier le tout à chaque fois le mot de passe par défaut au moment
du changement est Apple. 
On peut le changer dans ressources c'est la propriété android.app.default_password.

Pour les endpoints steam

Pour les jeux les plus joués
Get http://localhost:8080/api/steam/GetMostPlayedGames/fr/0/5
fr est le country code et 0 est le premier choisi et 5 le dernier 
c'est vraiment simple même très con

Response 

````json
[
    {
        "name": "Counter-Strike: Global Offensive",
        "editor": "Valve",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/730/ss_118cb022b9a43f70d2e5a2df7427f29088b6b191.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/730/header.jpg",
        "description": "Counter-Strike: Global Offensive (CS: GO) expands upon the team-based action gameplay that it pioneered when it was launched 19 years ago.<br />\r\n<br />\r\nCS: GO features new maps, characters, weapons, and game modes, and delivers updated versions of the classic CS content (de_dust2, etc.).<br />\r\n<br />\r\n&quot;Counter-Strike took the gaming industry by surprise when the unlikely MOD became the most played online PC action game in the world almost immediately after its release in August 1999,&quot; said Doug Lombardi at Valve. &quot;For the past 12 years, it has continued to be one of the most-played games in the world, headline competitive gaming tournaments and selling over 25 million units worldwide across the franchise. CS: GO promises to expand on CS' award-winning gameplay and deliver it to gamers on the PC as well as the next gen consoles and the Mac.&quot;",
        "price": "0,0€",
        "id": 730
    },
    {
        "name": "Dota 2",
        "editor": "Valve",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/570/ss_ad8eee787704745ccdecdfde3a5cd2733704898d.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/570/header.jpg",
        "description": "<strong>The most-played game on Steam.</strong><br>Every day, millions of players worldwide enter battle as one of over a hundred Dota heroes. And no matter if it's their 10th hour of play or 1,000th, there's always something new to discover. With regular updates that ensure a constant evolution of gameplay, features, and heroes, Dota 2 has truly taken on a life of its own.<br><br><strong>One Battlefield. Infinite Possibilities.</strong><br>When it comes to diversity of heroes, abilities, and powerful items, Dota boasts an endless array—no two games are the same. Any hero can fill multiple roles, and there's an abundance of items to help meet the needs of each game. Dota doesn't provide limitations on how to play, it empowers you to express your own style.<br><br><strong>All heroes are free.</strong><br>Competitive balance is Dota's crown jewel, and to ensure everyone is playing on an even field, the core content of the game—like the vast pool of heroes—is available to all players. Fans can collect cosmetics for heroes and fun add-ons for the world they inhabit, but everything you need to play is already included before you join your first match.<br><br><strong>Bring your friends and party up.</strong><br>Dota is deep, and constantly evolving, but it's never too late to join. <br>Learn the ropes playing co-op vs. bots. Sharpen your skills in the hero demo mode. Jump into the behavior- and skill-based matchmaking system that ensures you'll <br>be matched with the right players each game.",
        "price": "0,0€",
        "id": 570
    },
    {
        "name": "Wallpaper Engine",
        "editor": "Wallpaper Engine Team",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/431960/ss_5aec3335b1ae2300aa91da990d7e24541ddcf68d.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/431960/header.jpg",
        "description": "Wallpaper Engine enables you to use live wallpapers on your Windows desktop. Various types of animated wallpapers are supported, including 3D and 2D animations, websites, videos and even certain applications. Choose an existing wallpaper or create your own and share it on the Steam Workshop! In addition to that, you can use the free Wallpaper Engine companion app for Android to transfer your favorite wallpapers to your Android mobile device and take your live wallpapers on the go.<br><br><strong>NEW:</strong> Use the free Android companion app to transfer your favorite wallpapers to your Android mobile device.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/431960/extras/title_features.png?t=1665921297\" /><br><br><ul class=\"bb_ul\"><li>Bring your desktop wallpapers alive with realtime graphics, videos, applications or websites.<br></li><li>Use animated screensavers while you are away from your computer.<br></li><li>Personalize animated wallpapers with your favorite colors.<br></li><li>Use interactive wallpapers that can be controlled with your mouse.<br></li><li>Many aspect ratios and native resolutions supported including 16:9, 21:9, 16:10, 4:3.<br></li><li>Multi monitor environments are supported.<br></li><li>Wallpapers will pause while playing games to save performance.<br></li><li>Create your own animated wallpapers in the Wallpaper Engine Editor.<br></li><li>Animate new live wallpapers from basic images or import HTML or video files for the wallpaper.<br></li><li>Use the Steam Workshop to share and download wallpapers for free.<br></li><li>Wallpaper Engine can be used at the same time as any other Steam game or application.<br></li><li>Supported video formats: mp4, WebM, avi, m4v, mov, wmv (for local files, Workshop only allows mp4).<br></li><li>Use the free Android companion app to take your favorite scene and video wallpapers on the go.<br></li><li>Support for Razer Chroma and Corsair iCUE.</li></ul><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/431960/extras/partners.png?t=1665921297\" /><br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/431960/extras/title_performance.png?t=1665921297\" /><h2 class=\"bb_tag\"></h2>Wallpaper Engine aims to deliver an entertaining experience while using as few system resources as possible. You can choose to automatically pause or completely stop the wallpaper while using another application or playing fullscreen (including borderless windowed mode) to not distract or hinder you while playing a game or working. Many options to tweak quality and performance allow you to make Wallpaper Engine fit your computer perfectly. As a general rule of thumb, 3D, 2D and video based wallpapers will perform best, while websites and applications will require more resources from your system. Having a dedicated GPU is highly recommended, but not required.<h2 class=\"bb_tag\"></h2><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/431960/extras/title_workshop.png?t=1665921297\" /><h2 class=\"bb_tag\"></h2>Choose from over a million free wallpapers from the Steam Workshop with new wallpapers being uploaded every day! Can't find a wallpaper that fits your mood? Let your imagination go wild by using the Wallpaper Engine Editor to create your own animated wallpapers from images, videos, websites or applications. A large selection of presets and effects allow you to animate your own images and share them on the Steam Workshop or to just use them for yourself.",
        "price": "3,99€",
        "id": 431960
    },
    {
        "name": "Apex Legends™",
        "editor": "Electronic Arts",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/1172470/ss_5c150b9e86863e73fa4924657f6109db0e3b46a1.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/1172470/header.jpg",
        "description": "Conquer with character in Apex Legends, a free-to-play* Hero shooter where legendary characters with powerful abilities team up to battle for fame &amp; fortune on the fringes of the Frontier.<br><br>Master an ever-growing roster of diverse Legends, deep-tactical squad play, and bold, new innovations that go beyond the Battle Royale experience — all within a rugged world where anything goes. Welcome to the next evolution of Hero Shooter.<br><br><strong>KEY FEATURES</strong><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1172470/extras/changesthegame.png?t=1670431796\" /><br><strong>A Roster of Legendary Characters</strong> — Master a growing roster of powerful Legends, each with their own unique personality, strengths, and abilities that are easy to pick up but challenging to truly master.<br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1172470/extras/buildyourcrew.png?t=1670431796\" /><br><strong>Build Your Crew</strong> — Choose your Legend and combine their unique skills together with other players to form the ultimate crew.<br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1172470/extras/strategiccombat.png?t=1670431796\" /><br><strong>Strategic Squad Play</strong> — Whether you're battling on a massive, floating city in Battle Royale or dueling in close-quarters Arenas, you'll need to think fast. Master your Legend's unique abilities and coordinate with your teammates to discover new tactics and powerful combinations.<br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1172470/extras/newcastle.png?t=1670431796\" /><br><strong>Innovative Combat</strong> — Master an expanding assortment of powerful weapons and equipment. You'll need to move fast and learn the rhythms of each weapon to get the most out of your arsenal. Plus, change it up in limited-time modes, and get ready for a boatload of new content each season.<br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1172470/extras/everexpanding_universe.png?t=1670431796\" /><br><strong>Ever-expanding Universe</strong> — Apex Legends takes place in an immersive universe where the story continues to evolve, maps change each season, and new Legends keep joining the fight. Make your mark on the Apex Games with a multitude of distinctive outfits, and join the adventure!<br><br>This game includes optional in-game purchases of virtual currency that can be used to acquire virtual in-game items, including a random selection of virtual in-game items.",
        "price": "0,0€",
        "id": 1172470
    },
    {
        "name": "PUBG: BATTLEGROUNDS",
        "editor": "KRAFTON, Inc.",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/578080/ss_f148e1cd44da2972d1b61da1e12b7b3587c1f6a3.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/578080/header.jpg",
        "description": "<strong>LAND, LOOT, SURVIVE!</strong><br>Play PUBG: BATTLEGROUNDS for free.<br>Land on strategic locations, loot weapons and supplies, and survive to become the last team standing across various, diverse Battlegrounds.<br>Squad up and join the Battlegrounds for the original Battle Royale experience that only PUBG: BATTLEGROUNDS can offer.<br><br>This content download will also provide access to the BATTLEGROUNDS Test Server, which requires a separate download to play. <br>Optional in-game purchases available.",
        "price": "0,0€",
        "id": 578080
    }
]
````

Pour le detail d'un jeu

Get http://localhost:8080/api/steam/details/311210/fr
311210 est l'id et fr le country code 

Response:
````json
{
    "name": "Call of Duty®: Black Ops III",
    "editor": "Activision",
    "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/311210/ss_ca7376d838d5714f916936f0070824c27c4c5641.1920x1080.jpg",
    "cover": "https://cdn.akamai.steamstatic.com/steam/apps/311210/header.jpg",
    "description": "<h1>Zombies Chronicles Deluxe Edition</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3_Zombies_Chronicles_Deluxe-PC_Bundle-Banner_Special_Announcement-628x230.png?t=1646763462\" /><br><br>Now with more content than ever before.<br><br>Call of Duty®: Black Ops III Zombies Chronicles Deluxe includes the full base game, Season Pass, Zombies Chronicles &amp; additional bonus digital content including:<br><br>The Giant Bonus Map: Zombies returns in all of its undead glory with &quot;The Giant&quot;. Re-live the chaos of Treyarch's classic &quot;Der Riese&quot; Zombies map, picking up the Zombies story with Dempsey, Nikolai, Richtofen, and Takeo where Origins left off.<br><br>3 Personalization Packs: Fan favorite Cyborg &amp; Weaponized 115 packs along with a new Black Ops 3 pack. Each pack comes with a weapon camo, reticles, and calling card.<br><br>The Zombies Chronicles content expansion which delivers 8 remastered classic maps from  Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II.</p><br><h1>Mod Tools Open Beta Now Live</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3-PC_ModTools-Art_Logo-616x232.png?t=1646763462\" /><br><br>The Black Ops 3 Mod Tools Open Beta has arrived!  Full version Black Ops 3 owners can install the Mod Tools under the Tool Section via the Steam Library titled <strong><i>Call of Duty: Black Ops III - Mod Tools</i></strong>.<h2 class=\"bb_tag\">Mod Tools Include:</h2><ul class=\"bb_ul\"><li>Black Ops 3 Steam Workshop*<br></li><li>Unranked Server Browser*<br></li><li>Radiant Level Editor<br></li><li>APE, Asset Property Editor<br></li><li>Mod Tools Launcher<br></li><li>Optional additional level building assets from a variety of official Black Ops 3 maps can be installed under the DLC section of Call of Duty: Black Ops III - Mod Tools<br></li><li>Full examples of the multiplayer map Combine and the Zombies map The Giant<br></li><li>New Server Settings Menu in Multiplayer Custom Games and Zombies Private Game where you can set how your server will display in the Unranked Server Browser*<br></li><li>New Mods Menu where you can load and unload your subscribed mods*</li></ul><br>*<i>Downloading the mod tools is not required for these items or to play Black Ops 3 Steam Workshop content</i><h2 class=\"bb_tag\">Modding Guides:</h2><ul class=\"bb_ul\"><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=768774420\" target=\"_blank\" rel=\"\"  ><u>Official - How to Play - Workshop Guide</u></a><br></li><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=770558798\" target=\"_blank\" rel=\"\"  ><u>Official - How to Create - Workshop Guide</u></a></li></ul></p><br><h1>About the Game</h1>Call of Duty®: Black Ops III Zombies Chronicles Edition includes the full base game and the Zombies Chronicles content expansion.<br><br>Call of Duty: Black Ops III combines three unique game modes: Campaign, Multiplayer, and Zombies, providing fans with the deepest and most ambitious Call of Duty ever.<br><br>The Zombies Chronicles content expansion delivers 8 remastered classic Zombies maps from Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II. Complete maps from the original saga are fully remastered and HD playable within Call of Duty®: Black Ops III.",
    "price": "59,99€"
}
````

Pour faire la recherche d'un jeu

Get http://localhost:8080/api/steam/search/b
b est le mot rechercher


Response :
`````json
[
    {
        "name": "Call of Duty®: Black Ops III",
        "editor": "Activision",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/311210/ss_ca7376d838d5714f916936f0070824c27c4c5641.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/311210/header.jpg",
        "description": "<h1>Zombies Chronicles Deluxe Edition</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3_Zombies_Chronicles_Deluxe-PC_Bundle-Banner_Special_Announcement-628x230.png?t=1646763462\" /><br><br>Now with more content than ever before.<br><br>Call of Duty®: Black Ops III Zombies Chronicles Deluxe includes the full base game, Season Pass, Zombies Chronicles &amp; additional bonus digital content including:<br><br>The Giant Bonus Map: Zombies returns in all of its undead glory with &quot;The Giant&quot;. Re-live the chaos of Treyarch's classic &quot;Der Riese&quot; Zombies map, picking up the Zombies story with Dempsey, Nikolai, Richtofen, and Takeo where Origins left off.<br><br>3 Personalization Packs: Fan favorite Cyborg &amp; Weaponized 115 packs along with a new Black Ops 3 pack. Each pack comes with a weapon camo, reticles, and calling card.<br><br>The Zombies Chronicles content expansion which delivers 8 remastered classic maps from  Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II.</p><br><h1>Mod Tools Open Beta Now Live</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3-PC_ModTools-Art_Logo-616x232.png?t=1646763462\" /><br><br>The Black Ops 3 Mod Tools Open Beta has arrived!  Full version Black Ops 3 owners can install the Mod Tools under the Tool Section via the Steam Library titled <strong><i>Call of Duty: Black Ops III - Mod Tools</i></strong>.<h2 class=\"bb_tag\">Mod Tools Include:</h2><ul class=\"bb_ul\"><li>Black Ops 3 Steam Workshop*<br></li><li>Unranked Server Browser*<br></li><li>Radiant Level Editor<br></li><li>APE, Asset Property Editor<br></li><li>Mod Tools Launcher<br></li><li>Optional additional level building assets from a variety of official Black Ops 3 maps can be installed under the DLC section of Call of Duty: Black Ops III - Mod Tools<br></li><li>Full examples of the multiplayer map Combine and the Zombies map The Giant<br></li><li>New Server Settings Menu in Multiplayer Custom Games and Zombies Private Game where you can set how your server will display in the Unranked Server Browser*<br></li><li>New Mods Menu where you can load and unload your subscribed mods*</li></ul><br>*<i>Downloading the mod tools is not required for these items or to play Black Ops 3 Steam Workshop content</i><h2 class=\"bb_tag\">Modding Guides:</h2><ul class=\"bb_ul\"><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=768774420\" target=\"_blank\" rel=\"\"  ><u>Official - How to Play - Workshop Guide</u></a><br></li><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=770558798\" target=\"_blank\" rel=\"\"  ><u>Official - How to Create - Workshop Guide</u></a></li></ul></p><br><h1>About the Game</h1>Call of Duty®: Black Ops III Zombies Chronicles Edition includes the full base game and the Zombies Chronicles content expansion.<br><br>Call of Duty: Black Ops III combines three unique game modes: Campaign, Multiplayer, and Zombies, providing fans with the deepest and most ambitious Call of Duty ever.<br><br>The Zombies Chronicles content expansion delivers 8 remastered classic Zombies maps from Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II. Complete maps from the original saga are fully remastered and HD playable within Call of Duty®: Black Ops III."
    },
    {
        "name": "Dead by Daylight",
        "editor": "Behaviour Interactive Inc.",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/381210/ss_659500624438a4aa77bfdf304cba3ecebcd92ed9.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/381210/header.jpg",
        "description": "<h1>OVERVIEW</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/381210/extras/infograph_steam_new.png?t=1669150759\" /></p><br><h1>About the Game</h1><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/381210/extras/DeadbyDaylight_anime_Intro_Steam.jpg?t=1669150759\" /><h2 class=\"bb_tag\">Death Is Not an Escape.</h2><br>Dead by Daylight is a multiplayer (4vs1) horror game where one player takes on the role of the savage Killer, and the other four players play as Survivors, trying to escape the Killer and avoid being caught, tortured and killed.<br> <br>Survivors play in third-person and have the advantage of better situational awareness. The Killer plays in first-person and is more focused on their prey.<br> <br>The Survivors' goal in each encounter is to escape the Killing Ground without getting caught by the Killer - something that sounds easier than it is, especially when the environment changes every time you play.<br><br>More information about the game is available at <a href=\"https://steamcommunity.com/linkfilter/?url=http://www.deadbydaylight.com\" target=\"_blank\" rel=\" noopener\"  >http://www.deadbydaylight.com</a><h2 class=\"bb_tag\">Key Features</h2>•\t<strong>Survive Together… Or Not</strong> - Survivors can either cooperate with the others or be selfish. Your chance of survival will vary depending on whether you work together as a team or if you go at it alone. Will you be able to outwit the Killer and escape their Killing Ground?<br><br>•\t<strong>Where Am I?</strong> - Each level is procedurally generated, so you’ll never know what to expect. Random spawn points mean you will never feel safe as the world and its danger change every time you play.<br><br>•\t<strong>A Feast for Killers</strong> - Dead by Daylight draws from all corners of the horror world. As a Killer you can play as anything from a powerful Slasher to terrifying paranormal entities. Familiarize yourself with your Killing Grounds and master each Killer’s unique power to be able to hunt, catch and sacrifice your victims.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/381210/extras/DBD_HillB_Trapper_Wraith_anime_Steam.jpg?t=1669150759\" /><br><br>•\t<strong>Deeper and Deeper</strong> - Each Killer and Survivor has their own deep progression system and plenty of unlockables that can be customized to fit your own personal strategy. Experience, skills and understanding of the environment are key to being able to hunt or outwit the Killer.<br><br>•\t<strong>Real People, Real Fear</strong> - The procedural levels and real human reactions to pure horror makes each game session an unexpected scenario. You will never be able to tell how it’s going to turn out. Ambience, music, and chilling environments combine into a terrifying experience. With enough time, you might even discover what’s hiding in the fog.<br><br><br><strong>WARNING: PHOTOSENSITIVITY/EPILEPSY SEIZURES - READ THIS NOTICE BEFORE PLAYING</strong><br><br><i>A very small percentage of people may experience epileptic seizures or blackouts when exposed to certain kinds of flashing lights or light patterns. These persons, or even people who have no history of seizures or epilepsy, may experience epileptic symptoms or seizures while playing video games. If you or any of your relatives has an epileptic condition or has had seizures of any kind, consult your physician before playing any video game.<br><br>IMMEDIATELY DISCONTINUE use and consult a physician if you or your child experience any of the following symptoms: dizziness, altered vision, eye or muscle twitching, involuntary movements, loss of awareness, disorientation, or convulsions. Parents should watch for or ask their children about the above symptoms.<br><br>You may reduce risk of photosensitive epileptic seizures by taking the following precautions: sit farther from the screen, use a smaller screen, play in a well-lit room, do not play when you are drowsy or fatigued.</i>"
    },
    {
        "name": "Baldur's Gate 3",
        "editor": "Larian Studios",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/1086940/ss_dc47f50e35120c46eb444f1421722d72ad188aca.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/1086940/header.jpg",
        "description": "<img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/Larian_Steam_new_KeyArt_ready.gif?t=1671728446\" /><br><br>Gather your party, and return to the Forgotten Realms in a tale of fellowship and betrayal, sacrifice and survival, and the lure of absolute power. <br><br>Mysterious abilities are awakening inside you, drawn from a Mind Flayer parasite planted in your brain. Resist, and turn darkness against itself. Or embrace corruption, and become ultimate evil.  <br><br>From the creators of Divinity: Original Sin 2 comes a next-generation RPG, set in the world of Dungeons and Dragons.  <br><br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/Gather_new.gif?t=1671728446\" /><br><br>Choose from a wide selection of D&amp;D races and classes, or play as an origin character with a hand-crafted background. Adventure, loot, battle and romance as you journey through the Forgotten Realms and beyond. Play alone, and select your companions carefully, or as a party of up to four in multiplayer. <br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/An_expansive_original_story.png?t=1671728446\" /><br><br>Abducted, infected, lost. You are turning into a monster, but as the corruption inside you grows, so does your power. That power may help you to survive, but there will be a price to pay, and more than any ability, the bonds of trust that you build within your party could be your greatest strength. Caught in a conflict between devils, deities, and sinister otherworldly forces, you will determine the fate of the Forgotten Realms together.<br><br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/Next_Gen_new.gif?t=1671728446\" /><br><br>Forged with the new Divinity 4.0 engine, Baldur’s Gate 3 gives you unprecedented freedom to explore, experiment, and interact with a world that reacts to your choices. A grand, cinematic narrative brings you closer to your characters than ever before, as you venture through our biggest world yet. <br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/No_adventure_will_be_the_same.png?t=1671728446\" /><br><br>The Forgotten Realms are a vast, detailed and diverse  world, and there are secrets to be discovered all around you -- verticality is a vital part of exploration. Sneak, dip, shove, climb, and jump as you journey from the depths of the Underdark to the glittering rooftops of the Upper City. How you survive, and the mark you leave on the world, is up to you.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/01_Bullets_points.png?t=1671728446\" /><br><ul class=\"bb_ul\">allows you to combine your forces in combat, and split your party to follow your own quests and agendas. Concoct the perfect plan together… or introduce an element of chaos when your friends least expect it.</ul><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/02_Bullets_points.png?t=1671728446\" /><br><ul class=\"bb_ul\">offer a hand-crafted experience, each with their own unique traits, agenda, and outlook on the world. Their stories intersect with the entire narrative, and your choices will determine whether those stories end in redemption, salvation, domination, or many other outcomes. </ul><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/03_Bullets_points.png?t=1671728446\" /> <br><ul class=\"bb_ul\">based on the D&amp;D 5e ruleset. Team-based initiative, advantage &amp; disadvantage, and roll modifiers join combat cameras, expanded environmental interactions, and a new fluidity in combat that rewards strategy and foresight. </ul><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/04_Bullets_points.png?t=1671728446\" /> <br><ul class=\"bb_ul\">through your choices, and the roll of the dice. No matter who you play, or what you roll, the world and its inhabitants will react to your story.</ul> <br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/05_Bullets_points.png?t=1671728446\" /> <br><ul class=\"bb_ul\">allows you to pause the world around you at any time even outside of combat. Whether you see an opportunity for a tactical advantage before combat begins, want to pull off a heist with pin-point precision, or need to escape a fiendish trap. Split your party, prepare ambushes, sneak in the darkness -- create your own luck!  </ul><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1086940/extras/Final_Image_new.gif?t=1671728446\" />"
    },
    {
        "name": "Black Desert",
        "editor": "Pearl Abyss",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/582660/ss_ecb8cb71b127f9f6eea9bcdadddabd5b6d8f734f.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/582660/header_alt_assets_16.jpg",
        "description": "<h1>WHAT STEAM CURATORS HAVE TO SAY ABOUT BLACK DESERT</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/ENGLISH.png?t=1671510670\" /></p><br><h1>JOIN OUR DISCORD</h1><p><a href=\"https://steamcommunity.com/linkfilter/?url=https://discord.com/invite/blackdesertonline\" target=\"_blank\" rel=\" noopener\"  > <img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/Discord_616_110_2.png?t=1671510670\" /></p><br><h1>About the Game</h1><h2 class=\"bb_tag\">Go Beyond Limits : WORLD CLASS MMORPG</h2><br><i>Black Desert is a game that tests the limitations of MMORPG<br>by implementing remastered graphics and audio. Enjoy exciting combat and siege,<br>exploration, trading, fishing, training, alchemy, cooking, gathering, hunting, and more in the vast open world.<br>Black Desert - A true MMORPG</i><h2 class=\"bb_tag\">The Start of Your Dream Adventure</h2><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/Graphics_DescriptionCustomImage_616x250.jpg?t=1671510670\" /><br><strong>GRAPHICS</strong><br>Remastered Cutting-Edge Graphics<br>An expansive, open world MMORPG<br>made with Pearl Abyss’ proprietary game engine.<br>With spectacular sceneries, realistic environments, and sophisticated details.<br>Enter a world created with state-of-the-art graphics and prepare for unforgettable adventures.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/STEAM_OPENWORLD.png?t=1671510670\" /><br><strong>OPEN WORLD</strong><br>Multitudes of In-Game Activities<br>Don't feel like fighting?<br>Countless other activities await! Farming, trading, horse training, fishing, sailing, crafting, cooking…<br>Get immersed and dive into diverse life skills!<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/STEAM_KNOWLEDGE.png?t=1671510670\" /><br><strong>KNOWLEDGE</strong><br>Knowledge-Based Game Content<br>Knowledge is power!<br>Stick around and become an expert of the Black Desert world.<br>Gain knowledge from combat, exploring, or interacting with NPCs.<br>Knowledge will influence your gameplay and assist you on your adventures.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/STEAM_COMBAT.png?t=1671510670\" /><br><strong>COMBAT</strong><br>Non-Target &amp; Fast-Paced Combat<br>Experience an innovative combat system unlike any other MMORPG.<br>The need for quick reactions and precise control will keep you enthralled throughout your entire experience.<br>Exciting commands/combos will always keep you on your toes.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/NodeWar_DescriptionCustomImage_616x250.jpg?t=1671510670\" /><br><strong>NODE &amp; SIEGE WAR</strong><br>Large-Scale PvP Wars<br>Guilds, prepare for battle! Victory is near!<br>Join formidable guilds as they fight head-to-head on the battlefield.<br>Be victorious, become lords, and seize control of taxes, resources, and more!<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/582660/extras/customizing_DescriptionCustomImage_616x250.jpg?t=1671510670\" /><br><strong>CUSTOMIZING</strong><br>Become Your True Self<br>Experience insane levels of customization.<br>From height, torso, face, and skin texture,<br>to micro-level details, your imagination is the limit!<br>Create your own unique characters, just like you've always desired, in Black Desert.</a>"
    },
    {
        "name": "BeamNG.drive",
        "editor": "BeamNG",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/284160/ss_3db166b10f8826a58e1f4d6bf4a05d47a6a41823.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/284160/header.jpg",
        "description": "BeamNG.<i>drive</i> is an incredibly realistic driving game with near-limitless possibilities. Our soft-body physics engine simulates every component of a vehicle in real time, resulting in true-to-life behavior. With years of meticulous design, intensive research and experience, the simulation authentically recreates the excitement of real world driving. <br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/284160/extras/about_hero.png?t=1670937192\" /><h2 class=\"bb_tag\">Why is BeamNG.<i>drive</i> the game for you?</h2><br><strong>Soft-body physics: </strong>The BeamNG physics engine is at the core of the most detailed and authentic vehicle simulation you've ever seen in a game. Crashes feel visceral, as the game uses an incredibly accurate damage model. <br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/284160/extras/softbody_rockracer.gif?t=1670937192\" /><br><br><strong>Vehicles: </strong>BeamNG.<i>drive</i> offers dozens of refined, totally customizable vehicles for you to experiment with. Whether it's a compact car or massive truck, you can tweak away at all the moving parts to create just about any driving experience you want. Wheels, suspension, engines, and more; everything is under your control.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/284160/extras/vehicles.gif?t=1670937192\" /><br><br><strong>Environments:</strong> There's plenty to discover as you drive. Featuring 12 sprawling, beautiful open-world environments, the terrain feels as vast and diverse as the gameplay options. Test out your new setup through tropical jungle passages, barren deserts, urban boulevards, fast highways, and much more.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/284160/extras/env_short.gif?t=1670937192\" /><h2 class=\"bb_tag\">More features</h2><br><strong>Game Modes:</strong> This goes far deeper than your standard driving simulator. The range of gameplay options are exceptional, whether that's taking on a simple delivery mission or creating an entire map to test out new car builds.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/284160/extras/gameplay_hero.png?t=1670937192\" /><br><br><ul class=\"bb_ul\"><li><strong>Free Roam: </strong>Don't want to feel limited? Take any vehicle to your destination of choice and start exploring. Experimentation is also key in this game mode, as objects and environmental conditions can be manipulated. Try revving up wind speeds for a challenge, or altering gravity! <br></li><li><strong>Scenarios: </strong> BeamNG.<i>drive</i> offers loads of scenarios for every type of driving enthusiast out there. You can complete a truck delivery request as fast and efficiently as possible, or outrun police cruisers in a hot pursuit. No matter the situation, the realistic physics engine will engage and immerse you in the experience.  <br></li><li><strong>Time Trials: </strong>Choose a vehicle, environment, and route and put yourself to the test! Refine your skills and compete against yourself while improving your best time. </li></ul><br><strong>Modding and Community Content:</strong> We're proud of our vibrant community of enthusiasts that spark great conversation, while also creating interesting vehicle builds, terrains, and scenarios for others to enjoy. The modding capabilities in BeamNG.<i>drive</i> are vast, allowing you to customize and fine-tune just about anything. With our out-of-the-box World Editor everyone can put a twist on their in-game experience.<br><br><strong>Automation:</strong> We've partnered with Automation - the car company tycoon game - to allow players to export their creations into BeamNG.<i>drive</i>. If you own Automation, it's a fairly simple process: design your custom car and engine, tailor everything to your specifications, choose the &quot;export&quot; option, start up BeamNG.<i>drive</i>, and you'll be able to find your latest creation in the vehicle list! <br><br><strong>Freedom:</strong> What sets BeamNG.<i>drive</i> apart from other automotive games is player freedom. It’s about doing nearly anything you can think of with a car or truck and seeing it play out in the most realistic way possible. With our soft-body physics engine and modding capabilities, you can come up with any scenario imaginable. It's not just about the vehicles, it's about taking advantage of the expansive and customizable open world to create the driving experience you envision. Combining industry-leading physics, endless customization, and tight-knit community means that BeamNG.<i>drive</i> is the most comprehensive and flat-out fun vehicle simulator you will ever play."
    },
    {
        "name": "Mount & Blade II: Bannerlord",
        "editor": "TaleWorlds Entertainment",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/261550/ss_569257e92fd31d58a6fe08053de637071b4518d3.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/261550/header.jpg",
        "description": "<img src=\"https://cdn.akamai.steamstatic.com/steam/apps/261550/extras/1.jpg?t=1671213711\" /><br><br>The horns sound, the ravens gather. An empire is torn by civil war. Beyond its borders, new kingdoms rise. Gird on your sword, don your armour, summon your followers and ride forth to win glory on the battlefields of Calradia. Establish your hegemony and create a new world out of the ashes of the old.<br><br>Mount &amp; Blade II: Bannerlord is the eagerly awaited sequel to the critically acclaimed medieval combat simulator and role-playing game, Mount &amp; Blade: Warband. <br><br>Create and develop a character that matches your play style as you explore, raid and conquer your way across a vast medieval sandbox where no two playthroughs are the same. <br><br>Raise armies, engage in politics, trade, craft weapons, recruit companions and manage your fiefdom as you attempt to establish your clan among the nobility of Calradia. <br><br>Command and fight alongside your troops in first- or third-person in huge real-time battles using Mount &amp; Blade’s deep but intuitive skill-based directional combat system.<br><br>Put your combat prowess to the test against players from all over the world in multi-player PvP, including ranked matchmaking and casual game modes, or host your own server with the Mount &amp; Blade II: Dedicated Server files. <br><br>Customise the game to experience an entirely different adventure using the Mount &amp; Blade II: Bannerlord - Modding Kit and share your creations with others through Steam Workshop."
    },
    {
        "name": "The Binding of Isaac: Rebirth",
        "editor": "Nicalis, Inc.",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/250900/ss_25a4a446a433218d41a7e87e35b60c297e68e7a4.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/250900/header.jpg",
        "description": "<h1>New DLC Available</h1><p><a href=\"https://store.steampowered.com/app/1426300/The_Binding_of_Isaac_Repentance/\" target=\"_blank\" rel=\"\"  id=\"dynamiclink_0\" >https://store.steampowered.com/app/1426300/The_Binding_of_Isaac_Repentance/</a></p><br><h1>About the Game</h1>When Isaac’s mother starts hearing the voice of God demanding a sacrifice be made to prove her faith, Isaac escapes into the basement facing droves of deranged enemies, lost brothers and sisters, his fears, and eventually his mother. <br><br><strong>Gameplay</strong><br>The Binding of Isaac is a randomly generated action RPG shooter with heavy Rogue-like elements. Following Isaac on his journey players will find bizarre treasures that change Isaac’s form giving him super human abilities and enabling him to fight off droves of mysterious creatures, discover secrets and fight his way to safety.<br><br><strong>About the Binding Of Isaac: Rebirth</strong><br>The Binding of Isaac: Rebirth is the ultimate of remakes with an all-new highly efficient game engine (expect 60fps on most PCs), all-new hand-drawn pixel style artwork, highly polished visual effects, all-new soundtrack and audio by the the sexy Ridiculon duo Matthias Bossi + Jon Evans. Oh yeah, and hundreds upon hundreds of designs, redesigns and re-tuned enhancements by series creator, Edmund McMillen. Did we mention the poop?<h2 class=\"bb_tag\">Key Features:</h2><ul class=\"bb_ul\"><li>Over 500 hours of gameplay<br></li><li>4 BILLION Seeded runs!<br></li><li>20 Challenge runs<br></li><li>450+ items, including 160 new unlockables<br></li><li>Integrated controller support for popular control pads!<br></li><li>Analog directional movement and speed<br></li><li>Tons of feature film quality animated endings<br></li><li>Over 100 specialized seeds<br></li><li>2-Player local co-op<br></li><li>Over 100 co-op characters<br></li><li>Dynamic lighting, visual effects and art direction<br></li><li>All-new game engine @60FPS 24/7<br></li><li>All-new soundtrack and sound design<br></li><li>Multiple Save slots<br></li><li>Poop physics!<br></li><li>The ultimate roguelike<br></li><li>A bunch of achievements</li></ul><br><strong>Uber secrets including: </strong><br><ul class=\"bb_ul\"><li>10 Playable Characters<br></li><li>100+ enemies, with new designs<br></li><li>Over 50 bosses, including tons of new and rare bosses<br></li><li>Rooms FULL OF POOP!<br></li><li>Mystic Runes<br></li><li>Upgradeable shops</li></ul>"
    },
    {
        "name": "Kena: Bridge of Spirits",
        "editor": "Ember Lab",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/1954200/ss_52e16ae68eadf382538cdaaa876f58f0e2e9c757.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/1954200/header.jpg",
        "description": "<i>Kena: Bridge of Spirits</i>: a story-driven, action adventure combining exploration with fast-paced combat. Untangle the past as Kena, a young Spirit Guide in search of the sacred Mountain Shrine. Help free the spirits trapped in a forgotten village with the help of the Rot, Kena's adorable (yet powerful) spirit companions.<h2 class=\"bb_tag\">Key Features</h2><strong>Build your Team</strong><br>Timid and illusive spirits scattered throughout the forest, the Rot maintain balance by decomposing dead and rotting elements. <br><ul class=\"bb_ul\"><li>Find and collect the Rot hidden around the village.<br></li><li>Unlock new powerful Rot abilities the more of them you discover.<br></li><li>Clear the corruption from the village using the Rot's powers.</li></ul><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1954200/extras/RotGetv2.gif?t=1664298117\" /><br><br><strong>Explore a Charming World</strong><br>Untangle the mystery of the village’s strange curse as you discover secrets and draw on the power from the Spirit Realm to restore this once-majestic world.<br><ul class=\"bb_ul\"><li>Explore every nook and cranny of the village to uncover secrets and rewards.<br></li><li>Discover collectable Rot Hats to customize your Rot companions.<br></li><li>Locate and deliver Spirit Mail left behind by lost spirits to open up new areas.</li></ul><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1954200/extras/Adventurev2.gif?t=1664298117\" /><br><br><strong>Engage in Fast-Paced Combat</strong><br>Take on Corrupt Spirits, trapped and unable to move on, as they challenge Kena at every turn.<br><ul class=\"bb_ul\"><li>Hone your skills with various melee and ranged attacks.<br></li><li>Command the powers of your Rot companions with their powerful Rot Actions.<br></li><li>Upgrade your abilities and powers to become a skilled Spirit Guide.</li></ul><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1954200/extras/Combatv2.gif?t=1664298117\" /><br><br><strong>Now Including all ANNIVERSARY UPDATE Content!</strong><br>Explore brand new features including: New Game+, Trials, Outfits &amp; more!<br><ul class=\"bb_ul\"><li><i><strong>New Game+</strong></i>: Begin a new adventure after completing the game, starting with all your abilities, upgrades, and Rot as you face new combat encounters, challenges and unique enemies.<br></li><li><i><strong>Spirit Guide Trials</strong></i>: Sharpen your skills  and unlock rewards in The Trials, including: Wave Defenses, Obstacle Courses, and the chance to take on key boss-fights again and again. <br></li><li><i><strong>Outfits</strong></i>: Unlock brand new outfits for Kena to wear by mastering The Trials.<br></li><li><i><strong>Charmstones</strong></i>: Discover Charmstones that can be equipped to provide different advantages and disadvantages to customize your playstyle.  <br></li><li><i><strong>Enhanced Photo Mode</strong></i>: Includes more fun poses, unique lighting setups, and even a moving camera feature!</li></ul><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/1954200/extras/ContinueGrainPass.gif?t=1664298117\" />"
    },
    {
        "name": "Call of Duty®: Black Ops II",
        "editor": "Activision",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/202970/ss_ac2194dfb623d65003f54450fb1824e5f181b27e.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/202970/header.jpg",
        "description": "Pushing the boundaries of what fans have come to expect from the record-setting entertainment franchise, Call of Duty®: Black Ops II propels players into a near future, 21st Century Cold War, where technology and weapons have converged to create a new generation of warfare."
    },
    {
        "name": "BLUE PROTOCOL",
        "editor": "Amazon Games",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/2139230/ss_820668033c382d05c51041e6e6470ab3bea94bba.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/2139230/header.jpg",
        "description": "An Epic Journey Through Time<br>You are on a quest to uncover the truth about your origins. On your travels you meet people from many worlds and make new friends with whom you share your adventures. Eventually, you find yourself facing an inescapable destiny that will determine the fate of planet Regnas.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/2139230/extras/blue_protocol_185_615x346.jpg?t=1671647228\" /><br><strong>Action-Packed Combat</strong><br>It doesn't matter if you're a beginner or an advanced player, the action-based combat system features simple controls that are customizable and able to match any playstyle.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/2139230/extras/customization-615x346.jpg?t=1671647228\" /><br><strong>Deep Customization</strong><br>Become your ideal self: choose your facial appearance, hairstyle, clothes, accessories, weapons, and mounts for a combination that's uniquely your personal style.<br><br><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/2139230/extras/blue_protocol_180_615x346.jpg?t=1671647228\" /><br><strong>Multiplayer Adventure</strong><br>Work together as a team with other players to tackle quests, fight boss battles, and engage in massive online raids against towering monsters."
    }
]
`````


Pour les review:

Get http://localhost:8080/api/steam/reviews/271590/0/10
271590 est l'id du jeu
0 est le début de review qu'on veut et 10 la fin

Response 
````json
[
    {
        "id": "76561198187128898",
        "like": false,
        "description": "Nobody reads the reviews anyways, so i'll just say i'm gay\n"
    },
    {
        "id": "76561198108976996",
        "like": false,
        "description": "you CANNOT play online without a modder killing and ear raping you with bs mods.\n\nRockstar fix the shit."
    },
    {
        "id": "76561198209465456",
        "like": false,
        "description": "GTA ONLINE :\n\nOnline multiplayer is a pain in the ass, cheater, modder etc.\nso don't expect buying this game and running around leveling and making money, meet some new friend. like any MMORPG out there, it's not.\n\ninstead, make private lobby, play with your friend, make your own community, do some random shit together.\n\nevery heist is GREAT, play it with your friend. i promise you will have a good time.\n\noverall, GTA Online is great, but don't expect you will have a good time on public lobby.\n\n\nGTA V STORY MODE : \n\nwhat can i say? graphic? story? gameplay? this game kill them all. even after 10 years."
    },
    {
        "id": "76561198882727791",
        "like": false,
        "description": "please add sex"
    },
    {
        "id": "76561198930098896",
        "like": false,
        "description": "GTA VI is coming in 2100"
    },
    {
        "id": "76561198421131192",
        "like": false,
        "description": "Game is meh, look at this instead.\n⠄⠄⣿⣿⣿⣿⠘⡿⢛⣿⣿⣿⣿⣿⣧⢻⣿⣿⠃⠸⣿⣿⣿⠄⠄⠄⠄⠄\n⠄⠄⣿⣿⣿⣿⢀⠼⣛⣛⣭⢭⣟⣛⣛⣛⠿⠿⢆⡠⢿⣿⣿⠄⠄⠄⠄⠄\n⠄⠄⠸⣿⣿⢣⢶⣟⣿⣖⣿⣷⣻⣮⡿⣽⣿⣻⣖⣶⣤⣭⡉⠄⠄⠄⠄⠄\n⠄⠄⠄⢹⠣⣛⣣⣭⣭⣭⣁⡛⠻⢽⣿⣿⣿⣿⢻⣿⣿⣿⣽⡧⡄⠄⠄⠄\n⠄⠄⠄⠄⣼⣿⣿⣿⣿⣿⣿⣿⣿⣶⣌⡛⢿⣽⢘⣿⣷⣿⡻⠏⣛⣀⠄⠄\n⠄⠄⠄⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠙⡅⣿⠚⣡⣴⣿⣿⣿⡆⠄\n⠄⠄⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠄⣱⣾⣿⣿⣿⣿⣿⣿⠄\n⠄⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⣿⠄\n⠄⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠣⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄\n⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠑⣿⣮⣝⣛⠿⠿⣿⣿⣿⣿⠄\n⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⠄⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄"
    },
    {
        "id": "76561199041322220",
        "like": false,
        "description": "Gta is just such a fun game and I've played it all my life, I would recommend playing in a solo session, but the gta storymode is also fun. Anyways, I would recommend the game to anybody who hasn't played it."
    },
    {
        "id": "76561198000854252",
        "like": false,
        "description": "I’m glad I was able to buy this game for the 16th time across all platforms, including PS3, PS4, XBOX360, NextBox, PC,  HyperNeoGeo, Gameboy advance and AndroidGO.\n\nI’m also glad that I cannot move any of my progress across these divided platforms or have any personal control over how I want to play.\n\nBuy my soul again, Rockstar. \nBuy me so hard."
    },
    {
        "id": "76561198117249457",
        "like": false,
        "description": "The game is almost 10 years old, but I just played it for the first time.\n\nConsidering how delighted I was discovering GTAIV (details, physics, lightning) I was already sitting down to V with a certain standard in my head. I perfectly remember a similar feeling when I sat down to VC after III.\n\n[h1]Style and Feelings[/h1]\n\nhttps://steamcommunity.com/sharedfiles/filedetails/?id=2798013381\n\nI won't elaborate, the game tastes like a really well-cooked, spiced dish, served just the way I wanted it, but damn, I didn't define \"it\" before.\n\nI remember a scene from the movie \"Coffee and Cigarettes\" [url=https://www.youtube.com/watch?v=8CX5xybN3wg]Watch![/url] The lady is sitting in a pub, drinking coffee the way she likes it. The waiter comes up, supposedly asking whether to refill, but without waiting for an answer, he pours more. Annoyed, she points out to him that she already had the perfect color and temperature and it was great (the coffee).\n\nNow:\n[olist][*]Was the physics in GTA IV better? Yes, it was, I noticed, but was it that much better? :wink: Not until I looked at those videos like \"Why GTAIV is better than V?\"\n\n[*]Are missions in V absurd and unrealistic? (because that's what I was told) Strangely enough, no, there are some unusual ones, but nowhere near the level of San Andreas!\n\n[*]Is the plot worse, incoherent? No, because this game is one big sandbox in which the creators skillfully entwined a lot of allusions. The plot isn't like one signature Christmas dish (like in VC or IV). It's like a great feast buffet where I leave full and having tasted everything, and at the end, someone next to me asked: \"Have you tried this?\" Works for me.[/olist]\n\nIn III and IV I missed wild, extra-urban areas, so I liked playing Mafia for instance. However, I will never forget the first time in SA I drove from San Fierro to Las Venturas, through those desert hills in Bone Country. I felt the same when I jumped in Trevor's shoes for the first time.\n\nThe difference between the possibilities in VC and SA was huge, in the latter, the latter there was too much of everything, and it was overwhelming. Here, it's fine, lots of mini-games (golf, tennis, yoga, etc.), enough clothes, plus jet ski, planes, car tuning. I am filled, not overfed.\n\n[h1]Characters and Plot[/h1]\n\nhttps://steamcommunity.com/sharedfiles/filedetails/?id=2903057273\n\nInterestingly, I've managed to avoid spoilers over the years. I knew that the game bows to movies, among others \"Heat\" (1995), but I didn't know it was that much! I dressed the characters in the screen above on purpose, because they are Waingro, Donald Breedan, and Neil McCauley respectively.\n\n\n[h1]Michael[/h1]\n\nMichael started out as my favorite character and ended up being the most irritating and a bit grossed out. His attitude and character can be summed up in his final words in the A-final:\n\n[quote]Surviving is winning, Franklin, everything else is bullshit. Fairy tales spun by people too afraid to look life in the eye. Whatever it takes, kid: survive.[/quote]\n\nKeyword: Survival.\n\n\n[h1]Trevor[/h1]\n\nWhen Trevor killed John in the beginning, I thought it was an exaggerated attempt to show how dangerous and unpredictable he is. But since then, he's only gotten better. Definitely the most coherent and deep character, despite the apparent madness. His attitude and character can be summed up in his final words in the B-final:\n\n[quote]Well, I can't! You're turning on him? I've had enough traitors in my life![/quote]\n\nKeyword: Authenticity.\n\n\n[h1]Franklin[/h1]\n\nFranklin, Franklin... everything and nothing, fun and boredom. I enjoyed playing it the least but ended up losing the most hours with him. Because he is practical, he has the most useful skill, funny dialogue. A bit like beating the fourth wall, in style, the least interesting character from the \"viewer\" point of view, but the most necessary from the \"player\" point of view.\n\nKeyword: I don't know, maybe the Fourth Wall.\n\n[h1]Gameplay[/h1]\n\nI like immersing in the presented world the most, and with the enormity and variety of LS and Blaine Country and the possibility of playing from the FPP view, GTAV is a great pleasure.\n\nhttps://steamcommunity.com/sharedfiles/filedetails/?id=2796358854\n\nRandom encounters are surprising. The biggest WTF I had was when I met two old men on the road trying to rape a girl. I laughed when I picked up a drunk couple and they started banging in the back of the car. Definitely an adult game, I reminded myself when I saw the short film \"The Loneliest Robot in Great Britain\" at the cinema.\n\nI would love to release a series in which I play without radar, hud, in FPP, and roleplay. The only thing missing is the physics from IV. On the other hand, it's GTA after all, and you can really have fun with V.\n\n[h1]Post Scriptum[/h1]\n\nI forgot about the muuusic. Countless stations, I didn't have time to listen to everything yet, but the absolute number 1 is the track when we pause the game: [url=https://www.youtube.com/watch?v=EdEdCQYdsxQ]Listen![/url] This style, this melancholy, sometimes I just stared at the map to listen, and you know, I'm over 30, so it affects me twice. Everything seems close, here and now, and yet so far away, someday, something, somewhere... As Neil said in the \"Heat\":\n\n[quote]Don't let yourself get attached to anything you are not willing to walk out on in 30 seconds flat if you feel the heat around the corner.[/quote]\nAnd so it hits an adult man, these 30 seconds, at certain moments, and these 30 minutes or days at other times, and these 30 years. Where is the dream, where is the reality?\n\n[url=https://steamcommunity.com/id/lux_vq/screenshots/?appid=271590]My gallery on Steam[/url]\n\n[table]\n    [tr]\n        [td]Story & World[/td]\n        [td]10[/td]\n    [/tr]\n    [tr]\n        [td]Video[/td]\n        [td]10[/td]\n    [/tr]\n    [tr]\n        [td]Audio[/td]\n        [td]9[/td]\n    [/tr]\n    [tr]\n        [td]Gameplay[/td]\n        [td]10[/td]\n    [/tr]\n    [tr]\n        [th]Overall[/th]\n        [th]10[/th]\n    [/tr]\n[/table]"
    },
    {
        "id": "76561198086493619",
        "like": false,
        "description": "Crashed more than the fucking stock market."
    }
]
````

Whishlist endpoint

Pour ajouter un jeu a la whishlist 

Post http://localhost:8080/api/list/save/whishlist/311210

311210 est le steam id du jeu

Response 
````json
{
    "id": "63b0144ed593fc5fddfbe10c",
    "tenant": "63adc6c89c982d568dd84b9e",
    "name": "Call of Duty®: Black Ops III",
    "steamID": 311210,
    "editor": "Activision",
    "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/311210/ss_ca7376d838d5714f916936f0070824c27c4c5641.1920x1080.jpg",
    "cover": "https://cdn.akamai.steamstatic.com/steam/apps/311210/header.jpg",
    "description": "<h1>Zombies Chronicles Deluxe Edition</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3_Zombies_Chronicles_Deluxe-PC_Bundle-Banner_Special_Announcement-628x230.png?t=1646763462\" /><br><br>Now with more content than ever before.<br><br>Call of Duty®: Black Ops III Zombies Chronicles Deluxe includes the full base game, Season Pass, Zombies Chronicles &amp; additional bonus digital content including:<br><br>The Giant Bonus Map: Zombies returns in all of its undead glory with &quot;The Giant&quot;. Re-live the chaos of Treyarch's classic &quot;Der Riese&quot; Zombies map, picking up the Zombies story with Dempsey, Nikolai, Richtofen, and Takeo where Origins left off.<br><br>3 Personalization Packs: Fan favorite Cyborg &amp; Weaponized 115 packs along with a new Black Ops 3 pack. Each pack comes with a weapon camo, reticles, and calling card.<br><br>The Zombies Chronicles content expansion which delivers 8 remastered classic maps from  Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II.</p><br><h1>Mod Tools Open Beta Now Live</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3-PC_ModTools-Art_Logo-616x232.png?t=1646763462\" /><br><br>The Black Ops 3 Mod Tools Open Beta has arrived!  Full version Black Ops 3 owners can install the Mod Tools under the Tool Section via the Steam Library titled <strong><i>Call of Duty: Black Ops III - Mod Tools</i></strong>.<h2 class=\"bb_tag\">Mod Tools Include:</h2><ul class=\"bb_ul\"><li>Black Ops 3 Steam Workshop*<br></li><li>Unranked Server Browser*<br></li><li>Radiant Level Editor<br></li><li>APE, Asset Property Editor<br></li><li>Mod Tools Launcher<br></li><li>Optional additional level building assets from a variety of official Black Ops 3 maps can be installed under the DLC section of Call of Duty: Black Ops III - Mod Tools<br></li><li>Full examples of the multiplayer map Combine and the Zombies map The Giant<br></li><li>New Server Settings Menu in Multiplayer Custom Games and Zombies Private Game where you can set how your server will display in the Unranked Server Browser*<br></li><li>New Mods Menu where you can load and unload your subscribed mods*</li></ul><br>*<i>Downloading the mod tools is not required for these items or to play Black Ops 3 Steam Workshop content</i><h2 class=\"bb_tag\">Modding Guides:</h2><ul class=\"bb_ul\"><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=768774420\" target=\"_blank\" rel=\"\"  ><u>Official - How to Play - Workshop Guide</u></a><br></li><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=770558798\" target=\"_blank\" rel=\"\"  ><u>Official - How to Create - Workshop Guide</u></a></li></ul></p><br><h1>About the Game</h1>Call of Duty®: Black Ops III Zombies Chronicles Edition includes the full base game and the Zombies Chronicles content expansion.<br><br>Call of Duty: Black Ops III combines three unique game modes: Campaign, Multiplayer, and Zombies, providing fans with the deepest and most ambitious Call of Duty ever.<br><br>The Zombies Chronicles content expansion delivers 8 remastered classic Zombies maps from Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II. Complete maps from the original saga are fully remastered and HD playable within Call of Duty®: Black Ops III.",
    "price": "19,79€"
}
````

Pour lister la whishlist

GET http://localhost:8080/api/list/all/whishlist

Response
```json
[
    {
        "id": "63b0167800759d7d7ddedac2",
        "tenant": "63adc6c89c982d568dd84b9e",
        "name": "Call of Duty®: Black Ops III",
        "steamID": 311210,
        "editor": "Activision",
        "urlImage": "https://cdn.akamai.steamstatic.com/steam/apps/311210/ss_ca7376d838d5714f916936f0070824c27c4c5641.1920x1080.jpg",
        "cover": "https://cdn.akamai.steamstatic.com/steam/apps/311210/header.jpg",
        "description": "<h1>Zombies Chronicles Deluxe Edition</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3_Zombies_Chronicles_Deluxe-PC_Bundle-Banner_Special_Announcement-628x230.png?t=1646763462\" /><br><br>Now with more content than ever before.<br><br>Call of Duty®: Black Ops III Zombies Chronicles Deluxe includes the full base game, Season Pass, Zombies Chronicles &amp; additional bonus digital content including:<br><br>The Giant Bonus Map: Zombies returns in all of its undead glory with &quot;The Giant&quot;. Re-live the chaos of Treyarch's classic &quot;Der Riese&quot; Zombies map, picking up the Zombies story with Dempsey, Nikolai, Richtofen, and Takeo where Origins left off.<br><br>3 Personalization Packs: Fan favorite Cyborg &amp; Weaponized 115 packs along with a new Black Ops 3 pack. Each pack comes with a weapon camo, reticles, and calling card.<br><br>The Zombies Chronicles content expansion which delivers 8 remastered classic maps from  Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II.</p><br><h1>Mod Tools Open Beta Now Live</h1><p><img src=\"https://cdn.akamai.steamstatic.com/steam/apps/311210/extras/CODBO3-PC_ModTools-Art_Logo-616x232.png?t=1646763462\" /><br><br>The Black Ops 3 Mod Tools Open Beta has arrived!  Full version Black Ops 3 owners can install the Mod Tools under the Tool Section via the Steam Library titled <strong><i>Call of Duty: Black Ops III - Mod Tools</i></strong>.<h2 class=\"bb_tag\">Mod Tools Include:</h2><ul class=\"bb_ul\"><li>Black Ops 3 Steam Workshop*<br></li><li>Unranked Server Browser*<br></li><li>Radiant Level Editor<br></li><li>APE, Asset Property Editor<br></li><li>Mod Tools Launcher<br></li><li>Optional additional level building assets from a variety of official Black Ops 3 maps can be installed under the DLC section of Call of Duty: Black Ops III - Mod Tools<br></li><li>Full examples of the multiplayer map Combine and the Zombies map The Giant<br></li><li>New Server Settings Menu in Multiplayer Custom Games and Zombies Private Game where you can set how your server will display in the Unranked Server Browser*<br></li><li>New Mods Menu where you can load and unload your subscribed mods*</li></ul><br>*<i>Downloading the mod tools is not required for these items or to play Black Ops 3 Steam Workshop content</i><h2 class=\"bb_tag\">Modding Guides:</h2><ul class=\"bb_ul\"><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=768774420\" target=\"_blank\" rel=\"\"  ><u>Official - How to Play - Workshop Guide</u></a><br></li><li><a href=\"http://steamcommunity.com/sharedfiles/filedetails/?id=770558798\" target=\"_blank\" rel=\"\"  ><u>Official - How to Create - Workshop Guide</u></a></li></ul></p><br><h1>About the Game</h1>Call of Duty®: Black Ops III Zombies Chronicles Edition includes the full base game and the Zombies Chronicles content expansion.<br><br>Call of Duty: Black Ops III combines three unique game modes: Campaign, Multiplayer, and Zombies, providing fans with the deepest and most ambitious Call of Duty ever.<br><br>The Zombies Chronicles content expansion delivers 8 remastered classic Zombies maps from Call of Duty®: World at War, Call of Duty®: Black Ops and Call of Duty®: Black Ops II. Complete maps from the original saga are fully remastered and HD playable within Call of Duty®: Black Ops III.",
        "price": "19,79€"
    }
]
```


Pour delete un jeu dans la whishlist 
Il faut l'id du jeu dans la whishlist 

DELETE http://localhost:8080/api/list/delete/whishlist/63b0167800759d7d7ddedac2


Response 
rien 


