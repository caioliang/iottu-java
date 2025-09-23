package br.com.fiap.iottu.moto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> buscarTodas() {
        return motoRepository.findAll();
    }

    public void salvarMoto(Moto moto) {
        motoRepository.save(moto);
    }
}