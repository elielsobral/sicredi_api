package br.com.sicredi.application.usecase;

public interface UseCase<I , O> {
    O execute(I i);
}
