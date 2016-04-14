package ar.edu.unq.desapp.grupoA.models;

public interface ApplicationRequestState {
    public boolean isPending();

    public boolean isApproved();

    public boolean isReject();

    public void approve();

    public void reject();


}
