package cd.domain.mediator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import cd.domain.model.CD;
import cd.domain.model.CDList;
import cd.domain.model.CDTrack;
import cd.domain.model.Time;

public class CdTextFile implements CDPersistence
{
   private File file;

   public CdTextFile(String filename) throws IOException
   {
      file = new File(filename);
      if (file == null)
      {
         throw new FileNotFoundException(null);
      }
   }

   @Override
   public CDList load() throws FileNotFoundException
   {
      Scanner in = null;
      try
      {
         in = new Scanner(file);
         CDList cdList = new CDList();

         while (in.hasNext())
         {
            String[] lineToken = in.nextLine().split(";");
            String cdTitle = lineToken[0].trim();
            String cdArtist = lineToken[1].trim();
            int trackCount = Integer.parseInt(lineToken[2].trim());
            CDTrack[] tracks = new CDTrack[trackCount];
            for (int j = 0; j < trackCount; j++)
            {
               lineToken = in.nextLine().split(";");
               String trackTitle = lineToken[0].trim();
               String trackArtist = lineToken[1].trim();
               int day = Integer.parseInt(lineToken[2].trim());
               int month = Integer.parseInt(lineToken[3].trim());
               int year = Integer.parseInt(lineToken[4].trim());
               Time time = new Time(day, month, year);
               tracks[j] = new CDTrack(trackTitle, trackArtist, time);
            }
            CD cd = new CD(cdTitle, cdArtist, tracks);
            cdList.addCd(cd);
         }
         return cdList;
      }
      finally
      {
         in.close();
      }
   }

   @Override
   public void save(CDList cdList) throws FileNotFoundException
   {
      PrintWriter out = null;
      try
      {
         out = new PrintWriter(file);
         for (int i = 0; i < cdList.getNumberOfCds(); i++)
         {
            CD cd = cdList.getCD(i);
            out.println(cd.getTitle() + "; " + cd.getArtist() + "; "
                  + cd.getnumberOfTracks());
            for (int j = 0; j < cd.getnumberOfTracks(); j++)
            {
               CDTrack track = cd.getTrack(j);
               Time length = track.getLength();
               out.println(track.getTitle() + "; " + track.getArtist() + "; "
                     + length.getHour() + "; " + length.getMinute() + "; "
                     + length.getSecond());
            }

         }
         out.flush();
      }
      finally
      {
         out.close();
      }

   }

   @Override
   public void save(CD cd) throws IOException
   {
      PrintWriter out = null;
      try
      {
         FileWriter fileWriter = new FileWriter(file, true);
         out = new PrintWriter(fileWriter);
         out.println(cd.getTitle() + "; " + cd.getArtist() + "; "
               + cd.getnumberOfTracks());
         for (int j = 0; j < cd.getnumberOfTracks(); j++)
         {
            CDTrack track = cd.getTrack(j);
            Time length = track.getLength();
            out.println(track.getTitle() + "; " + track.getArtist() + "; "
                  + length.getHour() + "; " + length.getMinute() + "; "
                  + length.getSecond());
         }
         out.flush();
      }
      finally
      {
         out.close();
      }
   }

   @Override
   public void remove(CD cd) throws IOException
   {
      // inefficient
      CDList list = load();

      for (int i = 0; i < list.getNumberOfCds(); i++)
      {
         if (list.getCD(i).getTitle().equals(cd.getTitle())
               && list.getCD(i).getArtist().equals(cd.getArtist()))
         {
            list.removeCdByIndex(i);
            break;
         }
      }     
      clear();
      save(list);
   }

   @Override
   public void clear() throws IOException
   {
      file.delete();
   }
}
