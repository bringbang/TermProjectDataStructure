import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
class Airplane{
    private String brand ;
    private String form ;
    private String to ;
    private int price;
    private int distance;
    private List<VertexDijkstra> path;
    private String path1;
    private String type;
    private String status;
    public Airplane(String brand, String form, String to,int type, int price, int distance, List<VertexDijkstra> path,int status) {
        this.brand = brand;
        this.form = form;
        this.to = to;
        this.price = price;
        this.distance = distance;
        this.path = path;
        this.type = getType(type);
        this.path1 = setPath(path);
        this.status = getStatus(status);
    }
    public String getType(int type){
        String str = "";
        switch(type){
            case 0:
                str = "Economy";
            case 1:
                str = "Business";
            case 2:
                str = "First";
        }
        return str;
    }
    public String getBrand(){
        return brand;
    }
    public String getForm(){
        return form;
    }
    public String getTo(){
        return to;
    }
    public int getDistance(){
        return distance;
    }
    public String getStatus(int status){
        String str = "";
        switch(status){
            case 0:
                str = "BENEFIT";
            case 1:
                str = "HALFBENEFIT";
            case 2:
                str = "DONTBENEFIT";
        }
        return str;
    }
    public String setPath(List<VertexDijkstra> path){
        String Str = "";
        int count = 0;
        if(path.size()==2){
            Str+= path.get(0)+"-->"+path.get(1);
        
        }
        else if(path.size()==3){
            Str += path.get(0)+"-->"+path.get(1)+"-->"+path.get(2);
        }
        else if(path.size()==4){
            Str += path.get(0)+"-->"+path.get(1)+"-->"+path.get(2)+"-->"+path.get(3);
        }
        return Str;
    }
    public String toString(){
        return brand+" "+form+" "+to+" "+price+" "+distance+" "+path1;
    }
    public String getPath(){
        return path1;
    }
    public String getPrice(){
        return Integer.toString(price);
    }
}
public class CompareGraph extends javax.swing.JFrame {
    
    Random random = new Random();
    Dijkstra dijkstra = new Dijkstra();
    Dijkstra dijkstra1 = new Dijkstra();
    String[] town = {"Bangkok", "Seoul", "Singapore", "Tokyo", "Sydney", "Beijing", "Newyork", "Munich", "Heathrow"};
    String[] airplaneBrand = {"JapanAirline","KoreanAirline","Etihad","ThaiAirways"};
    VertexDijkstra[] ThaiAirways = new VertexDijkstra[town.length];
    VertexDijkstra[] BangkokAirWays = new VertexDijkstra[town.length];
     ArrayList<Airplane> plane = new ArrayList<>();
     ArrayList<Airplane> planeplane = new ArrayList<>();
     ArrayList<Airplane> planeTarget = new ArrayList<>();
     ArrayList<Airplane> planeTarget2 = new ArrayList<>();
    String Form = "";
    String To = "";
    ArrayList<EdgeDijkstra> edge = new ArrayList<>();
    ArrayList<EdgeDijkstra> edge1 = new ArrayList<>();
    int size = 0;
    int count = 0;
    int numberform = -1;
    int numberto = -1;
    int type = 0;
    void createDijkstraDirect(){
        for(int i=0;i<ThaiAirways.length;i++){
            ThaiAirways[i] =  new VertexDijkstra(town[i]);
        }
        int b1 = random.nextInt(100)+4000; //Bangkok -> Seoul
        int b2 = random.nextInt(100)+4000; //Bangkok -> Tokyo
        int b3 = random.nextInt(100)+7500; //Bangkok -> Sydney
        int b4 = random.nextInt(100)+1400; //Bangkok -> Singapore
        int b5 = random.nextInt(100)+8800; //Bangkok -> Munich
        int b6 = random.nextInt(100)+3300; //Bangkok -> Beijing
        int b7 = random.nextInt(100)+13000; // Bangkok -> Newyork
        int b8 = random.nextInt(100)+9500; // Bangkok -> Heathrow 
        int se1 = random.nextInt(100)+4600; // Seoul -> Singapore
        int se2 = random.nextInt(100)+1100; 
        int se3 = random.nextInt(100)+8300;
        int se4 = random.nextInt(100)+900;
        int se5 = random.nextInt(100)+11000;
        int se6 = random.nextInt(100)+8500;
        int se7 = random.nextInt(100)+8800;
        int si1 = random.nextInt(100)+6300;
        int si2 = random.nextInt(100)+5300;
        int si3 = random.nextInt(100)+10000;
        int si4 = random.nextInt(100)+4400;
        int si5 = random.nextInt(100)+16700;
        int si6 = random.nextInt(100)+10800;
        int to1 = random.nextInt(100)+7800;
        int to2 = random.nextInt(100)+9300;
        int to3 = random.nextInt(100)+2094;
        int to4 = random.nextInt(100)+10800;
        int to5 = random.nextInt(100)+9500;
        int sy1 = random.nextInt(100)+8900;
        int sy2 = random.nextInt(100)+17000;
        int sy3 = random.nextInt(100)+16300;
        int sy4 = random.nextInt(100)+17000;
        int be1 = random.nextInt(100)+7700;
        int be2 = random.nextInt(100)+8100;
        int be3 = random.nextInt(100)+10900;
        int ne1 = random.nextInt(100)+6400;
        int ne2 = random.nextInt(100)+5500;
        int mu1 = random.nextInt(100)+900;
        edge.add(new EdgeDijkstra(b1, ThaiAirways[0], ThaiAirways[1])); //Bangkok -> Seoul
        edge.add(new EdgeDijkstra(b4, ThaiAirways[0], ThaiAirways[2])); //Bangkok -> Singapore
        edge.add(new EdgeDijkstra(b2, ThaiAirways[0], ThaiAirways[3])); //Bangkok -> Tokyo
        edge.add(new EdgeDijkstra(b3, ThaiAirways[0], ThaiAirways[4])); //Bangkok -> Sydney
        edge.add(new EdgeDijkstra(b6, ThaiAirways[0], ThaiAirways[5])); //Bangkok ->`Beijing
        edge.add(new EdgeDijkstra(b7, ThaiAirways[0], ThaiAirways[6])); //Bangkok -> Newyork
        edge.add(new EdgeDijkstra(b5, ThaiAirways[0], ThaiAirways[7])); //Bangkok -> Munich
        edge.add(new EdgeDijkstra(b8, ThaiAirways[0], ThaiAirways[8])); //Bangkok -> Heathrow
        edge.add(new EdgeDijkstra(b1, ThaiAirways[1], ThaiAirways[0])); //Bangkok -> Seoul
        edge.add(new EdgeDijkstra(se1, ThaiAirways[1], ThaiAirways[2])); 
        edge.add(new EdgeDijkstra(se2, ThaiAirways[1], ThaiAirways[3])); 
        edge.add(new EdgeDijkstra(se3, ThaiAirways[1], ThaiAirways[4])); 
        edge.add(new EdgeDijkstra(se4, ThaiAirways[1], ThaiAirways[5])); 
        edge.add(new EdgeDijkstra(se5, ThaiAirways[1], ThaiAirways[6]));
        edge.add(new EdgeDijkstra(se6, ThaiAirways[1], ThaiAirways[7])); 
        edge.add(new EdgeDijkstra(se7, ThaiAirways[1], ThaiAirways[8])); 
        edge.add(new EdgeDijkstra(b1,ThaiAirways[1],ThaiAirways[0])); 
        edge.add(new EdgeDijkstra(se1, ThaiAirways[2], ThaiAirways[1])); 
        edge.add(new EdgeDijkstra(b4, ThaiAirways[2], ThaiAirways[0]));
        edge.add(new EdgeDijkstra(si2, ThaiAirways[2], ThaiAirways[3])); 
        edge.add(new EdgeDijkstra(si1, ThaiAirways[2], ThaiAirways[4])); 
        edge.add(new EdgeDijkstra(si3, ThaiAirways[2], ThaiAirways[7])); 
        edge.add(new EdgeDijkstra(si4, ThaiAirways[2], ThaiAirways[5])); 
        edge.add(new EdgeDijkstra(si5, ThaiAirways[2], ThaiAirways[6])); 
        edge.add(new EdgeDijkstra(si6, ThaiAirways[2], ThaiAirways[8])); 
        edge.add(new EdgeDijkstra(b1, ThaiAirways[3], ThaiAirways[0])); 
        edge.add(new EdgeDijkstra(si2, ThaiAirways[3], ThaiAirways[2])); 
        edge.add(new EdgeDijkstra(se2, ThaiAirways[3], ThaiAirways[1])); 
        edge.add(new EdgeDijkstra(to1, ThaiAirways[3], ThaiAirways[4])); 
        edge.add(new EdgeDijkstra(to2, ThaiAirways[3], ThaiAirways[7])); 
        edge.add(new EdgeDijkstra(to3, ThaiAirways[3], ThaiAirways[5])); 
        edge.add(new EdgeDijkstra(to4, ThaiAirways[3], ThaiAirways[6])); 
        edge.add(new EdgeDijkstra(to5, ThaiAirways[3], ThaiAirways[8])); 
        edge.add(new EdgeDijkstra(b3, ThaiAirways[4], ThaiAirways[0]));
        edge.add(new EdgeDijkstra(se3, ThaiAirways[4], ThaiAirways[1])); 
        edge.add(new EdgeDijkstra(si1, ThaiAirways[4], ThaiAirways[2])); 
        edge.add(new EdgeDijkstra(to1, ThaiAirways[4], ThaiAirways[3])); 
        edge.add(new EdgeDijkstra(sy3, ThaiAirways[4], ThaiAirways[7])); 
        edge.add(new EdgeDijkstra(sy1, ThaiAirways[4], ThaiAirways[5])); 
        edge.add(new EdgeDijkstra(sy2, ThaiAirways[4], ThaiAirways[6])); 
        edge.add(new EdgeDijkstra(sy4, ThaiAirways[4], ThaiAirways[8])); 
        edge.add(new EdgeDijkstra(b6, ThaiAirways[5], ThaiAirways[0])); 
        edge.add(new EdgeDijkstra(se4,ThaiAirways[5], ThaiAirways[1]));
        edge.add(new EdgeDijkstra(si4, ThaiAirways[5], ThaiAirways[2])); 
        edge.add(new EdgeDijkstra(to3, ThaiAirways[5], ThaiAirways[3])); 
        edge.add(new EdgeDijkstra(sy1, ThaiAirways[5], ThaiAirways[4])); 
        edge.add(new EdgeDijkstra(be1, ThaiAirways[5], ThaiAirways[7]));
        edge.add(new EdgeDijkstra(be3, ThaiAirways[5], ThaiAirways[6])); 
        edge.add(new EdgeDijkstra(be2, ThaiAirways[5], ThaiAirways[8])); 
        edge.add(new EdgeDijkstra(b7,ThaiAirways[6],ThaiAirways[0])); 
        edge.add(new EdgeDijkstra(se5, ThaiAirways[6], ThaiAirways[1])); 
        edge.add(new EdgeDijkstra(si5, ThaiAirways[6], ThaiAirways[2])); 
        edge.add(new EdgeDijkstra(to4, ThaiAirways[6], ThaiAirways[3])); 
        edge.add(new EdgeDijkstra(sy2, ThaiAirways[6], ThaiAirways[4])); 
        edge.add(new EdgeDijkstra(ne1, ThaiAirways[6], ThaiAirways[7])); 
        edge.add(new EdgeDijkstra(be3, ThaiAirways[6], ThaiAirways[5])); 
        edge.add(new EdgeDijkstra(ne2, ThaiAirways[6], ThaiAirways[8])); 
        edge.add(new EdgeDijkstra(mu1, ThaiAirways[7], ThaiAirways[8])); 
        edge.add(new EdgeDijkstra(b5, ThaiAirways[7], ThaiAirways[0])); 
        edge.add(new EdgeDijkstra(b4, ThaiAirways[7], ThaiAirways[2])); 
        edge.add(new EdgeDijkstra(si3, ThaiAirways[7], ThaiAirways[3])); 
        edge.add(new EdgeDijkstra(sy3, ThaiAirways[7], ThaiAirways[4])); 
        edge.add(new EdgeDijkstra(se6, ThaiAirways[7], ThaiAirways[1])); 
        edge.add(new EdgeDijkstra(be1, ThaiAirways[7], ThaiAirways[5])); 
        edge.add(new EdgeDijkstra(ne1, ThaiAirways[7], ThaiAirways[6])); 
        edge.add(new EdgeDijkstra(se7, ThaiAirways[8], ThaiAirways[1])); 
        edge.add(new EdgeDijkstra(b8, ThaiAirways[8], ThaiAirways[0])); 
        edge.add(new EdgeDijkstra(si6, ThaiAirways[8], ThaiAirways[2]));
        edge.add(new EdgeDijkstra(to5, ThaiAirways[8], ThaiAirways[3])); 
        edge.add(new EdgeDijkstra(sy4, ThaiAirways[8], ThaiAirways[4])); 
        edge.add(new EdgeDijkstra(mu1, ThaiAirways[8], ThaiAirways[7])); 
        edge.add(new EdgeDijkstra(be2, ThaiAirways[8], ThaiAirways[5])); 
        edge.add(new EdgeDijkstra(ne2, ThaiAirways[8], ThaiAirways[6])); 
        for(int i=0;i<edge.size();i++){
            if(edge.get(i).getStartVertex()==ThaiAirways[0]){
                ThaiAirways[0].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[1]){
                ThaiAirways[1].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[2]){
                ThaiAirways[2].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[3]){
                ThaiAirways[3].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[4]){
                ThaiAirways[4].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[5]){
                ThaiAirways[5].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[6]){
                ThaiAirways[6].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[7]){
                ThaiAirways[7].addNeighbour(edge.get(i));
            }
            else if(edge.get(i).getStartVertex()==ThaiAirways[8]){
                ThaiAirways[8].addNeighbour(edge.get(i));
            }
        }
    }
    void createDijkstraTransit_Direct(){
        count =0;
        for(int i=0;i<BangkokAirWays.length;i++){
            BangkokAirWays[i] =  new VertexDijkstra(town[i]);
        }
        int b1 = random.nextInt(100)+4000; //Bangkok -> Seoul
        int b2 = random.nextInt(100)+4000; //Bangkok -> Tokyo
        int b3 = random.nextInt(100)+7500; //Bangkok -> Sydney
        int b4 = random.nextInt(100)+1400; //Bangkok -> Singapore
        int b5 = random.nextInt(100)+8800; //Bangkok -> Munich
        int b6 = random.nextInt(100)+3300; //Bangkok -> Beijing
        int ne1 = random.nextInt(100)+6400;  // Newyork -> Munich
        int mu1 = random.nextInt(100)+900; // Munich -> Heathrow
        int se1 = random.nextInt(100)+11000; //Seoul -> Newyork 
        int se2 = random.nextInt(100)+8800; // Seoul -> Heathrow(United Kingdom)
        int to1 = random.nextInt(100)+11000; // Tokyo -> Newyork	
        int to2 = random.nextInt(100)+8800; // Tokyo -> Heathrow
        int to3 = random.nextInt(100)+1100; // Tokyo -> Seoul
        edge1.add(new EdgeDijkstra(b1, BangkokAirWays[0], BangkokAirWays[1])); //Bangkok -> Seoul
        edge1.add(new EdgeDijkstra(b4, BangkokAirWays[0], BangkokAirWays[2])); //Bangkok -> Singapore
        edge1.add(new EdgeDijkstra(b2, BangkokAirWays[0], BangkokAirWays[3])); //Bangkok -> Tokyo
        edge1.add(new EdgeDijkstra(b3, BangkokAirWays[0], BangkokAirWays[4])); //Bangkok -> Sydney
        edge1.add(new EdgeDijkstra(b5, BangkokAirWays[0], BangkokAirWays[7])); //Bangkok -> Munich
        edge1.add(new EdgeDijkstra(b6, BangkokAirWays[0], BangkokAirWays[5])); //Bangkok -> Beijing
        edge1.add(new EdgeDijkstra(se1,BangkokAirWays[1], BangkokAirWays[6])); //Seoul -> Newyork 
        edge1.add(new EdgeDijkstra(se2,BangkokAirWays[1], BangkokAirWays[8])); // Seoul -> Heathrow(United Kingdom)
        edge1.add(new EdgeDijkstra(b1,BangkokAirWays[1],BangkokAirWays[0])); //Seoul -> Bangkok
        edge1.add(new EdgeDijkstra(to1,BangkokAirWays[3],BangkokAirWays[6])); // Tokyo -> Newyork
        edge1.add(new EdgeDijkstra(to2,BangkokAirWays[3],BangkokAirWays[8])); // Tokyo -> Heathrow
        edge1.add(new EdgeDijkstra(b2, BangkokAirWays[3],BangkokAirWays[0])); // Tokyo -> Bangkok*/
        edge1.add(new EdgeDijkstra(to3,BangkokAirWays[3], BangkokAirWays[1])); // Tokyo -> Seoul
        edge1.add(new EdgeDijkstra(b2,BangkokAirWays[1], BangkokAirWays[3]));
        edge1.add(new EdgeDijkstra(b6,BangkokAirWays[5],BangkokAirWays[0])); //Beijing -> Bangkok
        edge1.add(new EdgeDijkstra(b4,BangkokAirWays[2],BangkokAirWays[0])); //Singapore -> Bangkok
        edge1.add(new EdgeDijkstra(ne1, BangkokAirWays[6],BangkokAirWays[7])); // Newyork -> Munich
        edge1.add(new EdgeDijkstra(to1,BangkokAirWays[6],BangkokAirWays[3])); // Newyork -> Tokyo
        edge1.add(new EdgeDijkstra(to2,BangkokAirWays[7],BangkokAirWays[3])); // Munich -> Tokyo
        edge1.add(new EdgeDijkstra(se2,BangkokAirWays[7],BangkokAirWays[1])); //Newyork -> Seoul 
        edge1.add(new EdgeDijkstra(mu1,BangkokAirWays[7],BangkokAirWays[8])); // Munich -> Heathrow
        edge1.add(new EdgeDijkstra(b5,BangkokAirWays[7],BangkokAirWays[0])); //Munich -> Bangkok 
        edge1.add(new EdgeDijkstra(mu1,BangkokAirWays[8], BangkokAirWays[7]));
        for(int i=0;i<edge1.size();i++){
            if(edge1.get(i).getStartVertex()==BangkokAirWays[0]){
                BangkokAirWays[0].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[1]){
                BangkokAirWays[1].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[2]){
                BangkokAirWays[2].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[3]){
                BangkokAirWays[3].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[4]){
                BangkokAirWays[4].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[5]){
                BangkokAirWays[5].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[6]){
                BangkokAirWays[6].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[7]){
                BangkokAirWays[7].addNeighbour(edge1.get(i));
            }
            else if(edge1.get(i).getStartVertex()==BangkokAirWays[8]){
                BangkokAirWays[8].addNeighbour(edge1.get(i));
            }
        }
    }
    void shortestPathDirect(int computenum,int number,int type,int peoplead,int peopleki){
        dijkstra.computePath(ThaiAirways[computenum]);
        int sumbefore = 0;
        if(peopleki>0){
            sumbefore = ThaiAirways[number].getPrice(type) -(ThaiAirways[number].getPrice(type)%40);
            if(peoplead>=3){
                 int sumbenefit = sumbefore + ((ThaiAirways[number].getPrice(type)- (ThaiAirways[number].getPrice(type) % 15))*peoplead);
                plane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumbenefit, ThaiAirways[number].getMinDistance(),dijkstra.getShortestPathTo(ThaiAirways[number]),0));
            }
            else if(peoplead<3){
                int sumhalfbenefit = sumbefore + (ThaiAirways[number].getPrice(type)*peoplead);
             plane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumhalfbenefit, ThaiAirways[number].getMinDistance(),dijkstra.getShortestPathTo(ThaiAirways[number]),1));
            }  
        }
        else{
            if(peoplead<3){
                int sumdontbenefit = ThaiAirways[number].getPrice(type)*peoplead;
            plane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumdontbenefit, ThaiAirways[number].getMinDistance(),dijkstra.getShortestPathTo(ThaiAirways[number]),2));
            }
            else if(peoplead<3){
                int sumhalfbenefit = ((ThaiAirways[number].getPrice(type)- (ThaiAirways[number].getPrice(type) % 15))*peoplead);
            plane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumhalfbenefit, ThaiAirways[number].getMinDistance(),dijkstra.getShortestPathTo(ThaiAirways[number]),1));
            }
        }
        shortestPathTransit(computenum, number, type,peoplead,peopleki);
    }
    void shortestPathTransit(int computenum,int number,int type,int peoplead,int peoplekids){
        dijkstra1.computePath(BangkokAirWays[computenum]);
        int sumbefore = 0;
        if(peoplekids>0){
            sumbefore = ((BangkokAirWays[number].getPriceTransit(type) - (BangkokAirWays[number].getPriceTransit(type)%60))*peoplekids);
            if(peoplead>=2){
                int sumbenefit = sumbefore + ((BangkokAirWays[number].getPriceTransit(type)-(BangkokAirWays[number].getPriceTransit(type)%20))*peoplead);
                planeplane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumbenefit, BangkokAirWays[number].getMinDistance(),dijkstra1.getShortestPathTo(BangkokAirWays[number]),0));
            }
            else if(peoplead<2){
                 int sumhalfbenefit = sumbefore+((BangkokAirWays[number].getPriceTransit(type)-(BangkokAirWays[number].getPriceTransit(type)%20))*peoplead);
             planeplane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumhalfbenefit, BangkokAirWays[number].getMinDistance(),dijkstra1.getShortestPathTo(BangkokAirWays[number]),1));
            }
        }
        else {
            if(peoplead>=2){
                int sumhalfbenefit = ((BangkokAirWays[number].getPriceTransit(type)-(BangkokAirWays[number].getPriceTransit(type)%20))*peoplead);
             planeplane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumhalfbenefit, BangkokAirWays[number].getMinDistance(),dijkstra1.getShortestPathTo(BangkokAirWays[number]),1));
            }
            else if(peoplead<2){
                int sumdontbenefit = (BangkokAirWays[number].getPriceTransit(type)*peoplead);
             planeplane.add(new Airplane(airplaneBrand[random.nextInt(4)],town[computenum], town[number],type,sumdontbenefit, BangkokAirWays[number].getMinDistance(),dijkstra1.getShortestPathTo(BangkokAirWays[number]),2));
            }
        }
    }
    void getPath(String form,String to,int type){
        for(int i=0;i<plane.size();i++){
            if(plane.get(i).getForm().equals(form)&&plane.get(i).getTo().equals(to)){
                if(plane.get(i).getType(type).equals("Economy")){
                    jTextField1.setText(plane.get(i).getPath()+" Distance = "+plane.get(i).getDistance());
                    jTextField3.setText(plane.get(i).getPrice());
                    break;
                    
                }
                else if(plane.get(i).getType(type).equals("Business")){
                    jTextField1.setText(plane.get(i).getPath()+" Distance = "+plane.get(i).getDistance());
                    jTextField3.setText(plane.get(i).getPrice());
                    break;
                }
                else if(plane.get(i).getType(type).equals("First")){
                    jTextField1.setText(plane.get(i).getPath()+" Distance = "+plane.get(i).getDistance());
                    jTextField3.setText(plane.get(i).getPrice());
                    break;
                }
            }
        }
        for(int i=0;i<planeplane.size();i++){
            if(planeplane.get(i).getForm().equals(form)&&planeplane.get(i).getTo().equals(to)){
                if(planeplane.get(i).getType(type).equals("Economy")){
                    jTextField2.setText(planeplane.get(i).getPath()+" Distance : "+planeplane.get(i).getDistance());
                    jTextField4.setText(planeplane.get(i).getPrice());
                    break;              
                }
                else if(planeplane.get(i).getType(type).equals("Business")){
                    jTextField2.setText(planeplane.get(i).getPath()+" Distance : "+planeplane.get(i).getDistance());
                    jTextField4.setText(planeplane.get(i).getPrice());
                    break;
                }
                else if(planeplane.get(i).getType(type).equals("First")){
                    jTextField2.setText(planeplane.get(i).getPath()+" Distance : "+planeplane.get(i).getDistance());
                    jTextField4.setText(planeplane.get(i).getPrice());
                    break;
                }
            }
        }
    }
    void create(){
        createDijkstraDirect();
        createDijkstraTransit_Direct();
        
    }
    public CompareGraph() {
        create();
        initComponents();
       // jLabel12.setIcon(new ImageIcon(getClass().getResource("sky-wallpapers-28043-8667192.jpg")));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 690));

        jPanel1.setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bangkok", "Seoul", "Singapore", "Tokyo", "Sydney", "Beijing", "Newyork", "Munich", "Heathrow" }));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(155, 203, 108, 28);

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel1.setText("Form :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(95, 206, 48, 22);

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel2.setText("To :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(281, 206, 30, 22);

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setText("Type : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(510, 200, 51, 22);

        jComboBox2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bangkok", "Seoul", "Singapore", "Tokyo", "Sydney", "Beijing", "Newyork", "Munich", "Heathrow" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(329, 203, 108, 28);

        jComboBox3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy Class", "Business Class", "First Class" }));
        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(570, 200, 145, 28);

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel4.setText("People  Adult :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(95, 272, 109, 22);

        jComboBox4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(220, 269, 42, 28);

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel5.setText("Kids (2-12 Year) :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(281, 272, 131, 22);

        jComboBox5.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        jPanel1.add(jComboBox5);
        jComboBox5.setBounds(417, 269, 42, 28);

        jTextField1.setFont(new java.awt.Font("Gill Sans MT", 0, 16)); // NOI18N
        jPanel1.add(jTextField1);
        jTextField1.setBounds(226, 370, 382, 30);

        jTextField2.setFont(new java.awt.Font("Gill Sans MT", 0, 16)); // NOI18N
        jPanel1.add(jTextField2);
        jTextField2.setBounds(226, 418, 382, 31);

        jTextField3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jPanel1.add(jTextField3);
        jTextField3.setBounds(689, 370, 111, 28);

        jTextField4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jPanel1.add(jTextField4);
        jTextField4.setBounds(689, 419, 111, 28);

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel7.setText("Price :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(631, 373, 46, 22);

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel8.setText("Price :");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(631, 422, 46, 22);

        jLabel9.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel9.setText("Direction 1 :");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(90, 373, 94, 22);

        jLabel10.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel10.setText("Direction 2 :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(90, 422, 94, 22);

        jLabel11.setFont(new java.awt.Font("Gill Sans MT", 0, 30)); // NOI18N
        jLabel11.setText("Give a Direction!!!");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(374, 73, 227, 35);

        jButton1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(510, 270, 120, 31);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sky-wallpapers-28043-8667192.jpg"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(0, 0, 990, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        create();
        int Form = jComboBox1.getSelectedIndex();
        int To = jComboBox2.getSelectedIndex();
        int Type = jComboBox3.getSelectedIndex();
        int adult = jComboBox4.getSelectedIndex()+1;
        int kids = jComboBox5.getSelectedIndex();
        String Form1  = jComboBox1.getSelectedItem().toString();
        String To1  = jComboBox2.getSelectedItem().toString();
        if(Form1.equals(To1)){
            JOptionPane.showMessageDialog(null,"Please Choose New City","Error!!!",JOptionPane.ERROR_MESSAGE);
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
             plane.clear();
            planeplane.clear();
        }
        else{
            shortestPathDirect(Form, To, Type,adult,kids);
            getPath(Form1,To1,Type);
            plane.clear();
            planeplane.clear();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompareGraph().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
