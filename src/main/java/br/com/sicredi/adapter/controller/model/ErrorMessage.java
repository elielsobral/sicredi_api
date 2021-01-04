package br.com.sicredi.adapter.controller.model;

import lombok.*;

@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private int status;
    private String message;
}
