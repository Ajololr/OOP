import Plagin1.Plagin1;
import sample.IService;

module plugin1 {
    requires lab;

    provides IService with Plagin1;
}