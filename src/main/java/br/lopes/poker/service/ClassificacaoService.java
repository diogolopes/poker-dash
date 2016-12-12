package br.lopes.poker.service;

import java.util.Map;
import java.util.Set;

import br.lopes.poker.data.Classificacao;
import br.lopes.poker.domain.Partida;
import br.lopes.poker.domain.Pessoa;
import br.lopes.poker.domain.Ranking;
import br.lopes.poker.domain.RankingType;

public interface ClassificacaoService {

    Map<Pessoa, Classificacao> ranking(final Partida partida, final RankingType rankingType);

    Map<Pessoa, Classificacao> ranking(final Set<Partida> partidas, final RankingType rankingType);

    void generateRankingFileByPartidasAndType(final Ranking ranking, final Set<Partida> partidas,
            final RankingType rankingType) throws Exception;

    void generateRankingFileByPartidasAndType(final Ranking ranking, final Set<Partida> partidas) throws Exception;

    void generateRankingFileByType(final Ranking ranking) throws Exception;

}
