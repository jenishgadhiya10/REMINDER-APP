package com.example.reminderapp.model;

public class SyncAccount {
    private String id;
    private String provider;
    private String email;
    private boolean isConnected;
    private String lastSynced;

    public SyncAccount(String id, String provider, String email, boolean isConnected, String lastSynced) {
        this.id = id;
        this.provider = provider;
        this.email = email;
        this.isConnected = isConnected;
        this.lastSynced = lastSynced;
    }

    public String getId() { return id; }
    public String getProvider() { return provider; }
    public String getEmail() { return email; }
    public boolean isConnected() { return isConnected; }
    public void setConnected(boolean connected) { isConnected = connected; }
    public String getLastSynced() { return lastSynced; }
}
