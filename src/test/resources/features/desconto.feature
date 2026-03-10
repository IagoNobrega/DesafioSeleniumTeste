#language: pt

Funcionalidade: Receber o cupom desconto da qazando
  Eu como usuario da qazando
  quero receber um cupom de desconto
  para comprar um curso com valor reduzido

  Cenario: visualiza codigo de desconto
    Dado que estou no site da qazando
    Quando eu preencha meu e-mail
    E clico em ganhar cupom
    Entao eu vejo o codigo de desconto
