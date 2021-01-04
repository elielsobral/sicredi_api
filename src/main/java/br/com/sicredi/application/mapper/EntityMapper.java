package br.com.sicredi.application.mapper;

public interface EntityMapper<I , O> {
    O map(I i);
}
