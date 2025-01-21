import Image from "next/image";

import Hero from "@/components/hero";
import Overview from "@/components/overview.mdx";

export default function IndexPage() {
  return (
    <div className="pt-8">
      <Hero />
      <div className="mt-8 flex flex-col items-center">
        <Image
          alt="screenshot"
          src="/screenshot-1.png"
          width={2100}
          height={1334}
          className="w-[640px] max-w-full"
        />
      </div>
      <div className="prose mt-8 max-w-none">
        <Overview />
      </div>
    </div>
  );
}
