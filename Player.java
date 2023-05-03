package org.example;

public class Player {
    private int playerRolled;
    private int playerScore;
    private int playerJustRolled;
    /**
     * Constructor that creates a new player.
     *  <p>
     *  Initializes all values of the player to 0, as if they were just starting a game.
     *  </p>
     */
    public Player() {
        this.playerRolled = 0;
        this.playerScore = 0;
        this.playerJustRolled = 0;
    }

    public int getPlayerRolled() {
        return this.playerRolled;
    }

    public int getPlayerScore() {
        return this.playerScore;
    }

    public int getPlayerJustRolled() {
        return this.playerJustRolled;
    }

    public void setPlayerRolled(int playerRolled) {
        this.playerRolled = playerRolled;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setPlayerJustRolled(int playerJustRolled) {
        this.playerJustRolled = playerJustRolled;
    }
}
