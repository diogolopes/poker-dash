package br.lopes.poker.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.lopes.poker.domain.PartidaPessoa.PartidaPessoaPK;

@Entity
public class PartidaPessoa extends AbstractEntity<PartidaPessoaPK> {

    private static final long serialVersionUID = -1349284861476161506L;

    private BigDecimal saldo;
    private BigDecimal bonus;

    @ManyToOne(optional = false)
    @JoinColumn(name = "partidaId",
            nullable = false,
            insertable = false,
            updatable = false)
    private Partida partida;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoaId",
            nullable = false,
            insertable = false,
            updatable = false)
    private Pessoa pessoa;

    public void setPartidaPessoa(Partida partida, Pessoa pessoa) {
        PartidaPessoaPK id = getId();
        if (id == null) {
            setId(new PartidaPessoaPK(partida, pessoa));
        } else {
            getId().setPartida(partida);
            getId().setPessoa(pessoa);
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Partida getPartida() {
        return partida;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(final BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(final BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Embeddable
    public static class PartidaPessoaPK implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne(optional = false)
        @JoinColumn(name = "partidaId",
                nullable = false)
        private Partida partida;

        @ManyToOne(optional = false)
        @JoinColumn(name = "pessoaId",
                nullable = false)
        private Pessoa pessoa;

        public PartidaPessoaPK() {
        }

        public PartidaPessoaPK(final Partida partida, final Pessoa pessoa) {
            this.partida = partida;
            this.pessoa = pessoa;
        }

        public Partida getPartida() {
            return partida;
        }

        public void setPartida(Partida partida) {
            this.partida = partida;
        }

        public Pessoa getPessoa() {
            return pessoa;
        }

        public void setPessoa(Pessoa pessoa) {
            this.pessoa = pessoa;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((partida == null) ? 0 : partida.hashCode());
            result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (!(obj instanceof PartidaPessoaPK))
                return false;
            PartidaPessoaPK other = (PartidaPessoaPK) obj;
            if (partida == null) {
                if (other.partida != null)
                    return false;
            } else if (!partida.equals(other.partida))
                return false;
            if (pessoa == null) {
                if (other.pessoa != null)
                    return false;
            } else if (!pessoa.equals(other.pessoa))
                return false;
            return true;
        }
    }

}
