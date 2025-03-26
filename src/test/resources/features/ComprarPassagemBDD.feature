# Feature: Comprar pasagem
#     Escolher e comprar passagens aereas

#     Scnenaio: Comprar com sucesso

#language: pt
Funcionalidade: Comprar Passagem
    Escolher e comprar passagens aereas

    Cenario: Comprar com sucesso
        Dado que acesso o site "https://blazedemo.com/"
        Quando seleciono a origem "São Paolo" e destino "Cairo"
        E clico no botão Find Flights
        Entao visualiza a lista de voos