import java.util.Random;

public class Game2048 {
    private int[][] matrix;
    private int N ;
    Random random;

    public Game2048(int N){
        this.N = N;
        random = new Random();
        matrix = new int[N][N];
        init();

    }

    private void init(){
        int R =  random.nextInt(N);
        int C = random.nextInt(N);
        matrix[R][C] = 2;
        R= random.nextInt(N);
        C= random.nextInt(N);
        matrix[R][C] = 2;
    }

    public void move(Action action){
        if(action.equals(Action.LEFT)){
           for(int i=0;i<N;i++){
               int first =0, second=0;
               for(second =0; second< N;second++){
                   if(matrix[i][second] != 0){
                       if(first != second && matrix[i][first]==matrix[i][second]){
                           matrix[i][first]*=2;
                           first++;
                           matrix[i][first]=0;
                       }
                       else if(first !=second && matrix[i][first]!= matrix[i][second] && matrix[i][first] != 0){
                           matrix[i][++first] = matrix[i][second];
                       }
                       else{
                           matrix[i][first]=matrix[i][second];
                       }
                   }
                   if(first!=second)
                        matrix[i][second]=0;
               }
           }
        }

        if(action.equals(Action.RIGHT)){
            for(int i=0;i<N;i++){
                int first =N-1, second=N-1;
                for(second =N-1; second>=0;second--){
                    if(matrix[i][second] != 0){
                        if(first != second && matrix[i][first]==matrix[i][second]){
                            matrix[i][first]*=2;
                            first--;
                            matrix[i][first]=0;
                        }
                        else if(first !=second && matrix[i][first]!= matrix[i][second] && matrix[i][first] != 0){
                            matrix[i][--first] = matrix[i][second];
                        }
                        else{
                            matrix[i][first]=matrix[i][second];
                        }
                    }
                    if(first!=second)
                        matrix[i][second]=0;
                }
            }
        }
        if(action.equals(Action.UP)){
            for(int i=0;i<N;i++){
                int first =0, second=0;
                for(second =0; second< N;second++){
                    if(matrix[second][i] != 0){
                        if(first != second && matrix[first][i]==matrix[second][i]){
                            matrix[first][i]*=2;
                            first++;
                            matrix[first][i]=0;
                        }
                        else if(first !=second && matrix[first][i]!= matrix[second][i] && matrix[first][i] != 0){
                            matrix[++first][i] = matrix[second][i];
                        }
                        else{
                            matrix[first][i]=matrix[second][i];
                        }
                    }
                    if(first!=second)
                        matrix[second][i]=0;
                }
            }
        }
        if(action.equals(Action.DOWN)){
            for(int i=0;i<N;i++){
                int first=N-1, second=N-1;
                for(second =N-1; second>=0;second--){
                    if(matrix[second][i] != 0){
                        if(first != second && matrix[first][i]==matrix[second][i]){
                            matrix[first][i]*=2;
                            first--;
                            matrix[first][i]=0;
                        }
                        else if(first !=second && matrix[first][i]!= matrix[second][i] && matrix[first][i] != 0){
                            matrix[--first][i] = matrix[second][i];
                        }
                        else{
                            matrix[first][i]=matrix[second][i];
                        }
                    }
                    if(first!=second)
                        matrix[second][i]=0;
                }
            }
        }
        //generate 2 and random empty location after each move
        int _R,_C;
        do {
            _R = random.nextInt(N);
            _C = random.nextInt(N);
            if(matrix[_R][_C]==0){
                matrix[_R][_C]=2;
                break;
            }

        }while (matrix[_R][_C] != 0);
    }

    public Result result(){
        boolean isFull = true;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(matrix[i][j] == Math.pow(2, N*N-1))
                    return Result.WON;
                else if(matrix[i][j] == 0)
                    isFull =false;
            }
        }
        return isFull ? Result.LOSE : Result.CONTINUE;
    }

    public void printBoard(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

}
