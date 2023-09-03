package br.com.fiap.challange.services;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import br.com.fiap.challange.entity.AbastecimentoEntity;
import br.com.fiap.challange.entity.EnderecoEntity;
import br.com.fiap.challange.exeptions.ChallangeException;
import br.com.fiap.challange.model.OpencageDTOPOST;

@Service
public class ConversionService {

	public static OpencageDTOPOST convertToOpencageDTO(AbastecimentoEntity abastecimento, EnderecoEntity endereco) {
        OpencageDTOPOST opencageDTO = new OpencageDTOPOST();

        opencageDTO.setAbastecimentoId(abastecimento.getAbastecimentoId());
        opencageDTO.setAbastecimentoDate(abastecimento.getAbastecimentoDate());
        opencageDTO.setAbastecimentoCoordenada(abastecimento.getAbastecimentoCoordenada());
        opencageDTO.setStatusCombustivelId(abastecimento.getStatusCombustivelId());
        opencageDTO.setTipoCombustivelId(abastecimento.getTipoCombustivelId());
        opencageDTO.setVeiculoId(abastecimento.getVeiculoId());
        opencageDTO.setEnderecoId(abastecimento.getEnderecoId());

        opencageDTO.setRua(endereco.getRua());
        opencageDTO.setBairro(endereco.getBairro());
        opencageDTO.setCidade(endereco.getCidade());
        opencageDTO.setPais(endereco.getPais());
        opencageDTO.setContinente(endereco.getContinente());
        opencageDTO.setTipoLugar(endereco.getTipoLugar());
        opencageDTO.setCep(endereco.getCep());

        return opencageDTO;
    }
	
    private static final Map<String, String> translations = new HashMap<>();
    
    static {
        translations.put("fuel", "Posto de Gasolina");
        translations.put("road", "Rua/Estrada");
        translations.put("building", "Construção/Prédio");
        translations.put("bus_stop", "Ponto de Ônibus");
    }
    
    public static String translateValues(String key) throws ChallangeException {
        if (verifyString.apply(key)) {
            return translations.getOrDefault(key, key);
        } else {
            throw new ChallangeException("A chave não pode ser nula ou vazia");
        }
    }
	
	public static Function<String, Boolean> verifyString = (str) -> Boolean.valueOf(str != null && !str.trim().isEmpty());
	
}
