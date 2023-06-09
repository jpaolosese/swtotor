# Star Wars: Text of the Old Republic

A long time ago, in a server far, far away...

## _STAR WARS: TEXT OF THE OLD REPUBLIC_

The Jedi are victorious. Peace reigns throughout the Republic. The remaining Sith have been driven back to the far edges of the galaxy, beyond the sight of the Jedi.

But the Sith are not so easily wiped out. Although few in number, there, in the dark corners of the galaxy, the Sith plot their revenge against the Republic.

A contingent of Dark Jedi have infiltrated some poor sap's program. The poor sap requests aid in completing his program and the Jedi Council has enlisted you, a Jedi, to infiltrate and fight the Sith within...

# Run

Run in terminal:

```console
javac Main.java
java Main
```

# Game
A text-based roguelike heavily inspired by _Star Wars: Knights of the Old Republic_. Players fight through a gauntlet of 15 randomly generated Dark Jedi, with a 1 in 5 chance (roughly 3) of them on average being Dark Jedi Masters.

Like the original game, there are three classes to choose from: 

* Jedi Guardian: Jedi Guardians battle against the forces of evil and the dark side. Higher health (600), lower (400) Force points.

* Jedi Sentinel: Jedi Sentinels ferret out deceit and injustice, bringing them to light. Equal Force points and health (500/500)

* Jedi Consular: Jedi Consulars seek to bring balance to the universe. Lower health (400), higher (600) Force points

Dark Jedi have 250 health and Force points. Dark Jedi Masters have 350 health and 300 Force points.

Players (and enemies) have access to a standard attack + 6 Force powers. Force point expenditure is dependent on class: 

1. Standard attack: Roughly the same standard attack as in _SW:KotOR_. Inflicts 20 damage.

2. Force Jump

3. Throw Lightsaber

4. Force Push

5. Force Poison - roughly like Plague from _SW:KotOR_

6. Force Choke

7. Force Lightning

Certain classes spend more points casting certain powers but inflict more damage.

## Force point expenditure

From most to least per class:

* Jedi Guardians:
    
    1. Force Jump, Throw Lightsaber
    2. Force Push, Force Lightning
    3. Force Choke, Force Poison

* Jedi Sentinels:

    1. Force Push, Force Poison
    2. Force Jump, Force Choke
    3. Throw Lightsaber, Force Lightning

* Jedi Consulars:

    1. Force Choke, Force Lightning
    2. Throw Lightsaber, Force Poison
    3. Force Jump, Force Push

Strongest powers spend 45 Force points and inflict 40 damage. Moderate strength powers spend 30 Force points and inflict 30 damage. Weakest powers spend 15 points and inflict 20 damage. Standard attacks do not spend Force points and inflict 20 damage.

In addition, there is a 5% chance (1d20) of either players or enemies landing a critical hit inflicting double damage.

Players have a 16.67% chance (1d6) of healing to full health, and a 12.5% chance (1d8) of restoring full Force points.